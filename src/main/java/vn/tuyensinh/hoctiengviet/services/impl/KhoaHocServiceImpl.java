package vn.tuyensinh.hoctiengviet.services.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.constant.Constant;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.CourseWebDTO;
import vn.tuyensinh.hoctiengviet.dto.StudentDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetListCourseOnWebParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.KhoaHoc;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.mapper.KhoaHocMapper;
import vn.tuyensinh.hoctiengviet.mapper.StudentMapper;
import vn.tuyensinh.hoctiengviet.model.request.ExcelRequest;
import vn.tuyensinh.hoctiengviet.model.request.KhoaHocRequest;
import vn.tuyensinh.hoctiengviet.model.response.KhoaHocRespone;
import vn.tuyensinh.hoctiengviet.model.response.KhoaHocResponeRegister;
import vn.tuyensinh.hoctiengviet.repository.KhoaHocRepository;
import vn.tuyensinh.hoctiengviet.repository.TrangThaiRepository;
import vn.tuyensinh.hoctiengviet.services.KhoaHocService;
import vn.tuyensinh.hoctiengviet.util.ParesStringToTimeStamp;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE;

@Service
public class KhoaHocServiceImpl implements KhoaHocService {

    @Autowired
    KhoaHocRepository khoaHocRepository;

    @Autowired
    private TrangThaiRepository trangThaiRepository;

    @Autowired
    private ParesStringToTimeStamp paresStringToTimeStamp;

    @Autowired
    private ExcelServicesImpl excelServices;

    @Autowired
    private KhoaHocMapper khoaHocMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<KhoaHoc> findAll(PageParam p) {

        Pageable pageable = PageRequest.of(p.getPageNo() - 1, p.getPageSize(), Sort.by("ID").descending());

        Page<KhoaHoc> list = khoaHocRepository.findAll(pageable);

        return list.toList();
    }

    @Override
    public List<CourseWebDTO> findAllEnable(PageParam p) {

        Pageable pageable = PageRequest.of(p.getPageNo() - 1, p.getPageSize(), Sort.by("ID").descending());

        TrangThai s= trangThaiRepository.findByID(1);

        Page<KhoaHoc> list = khoaHocRepository.findAllEnable(pageable,s);

        List<CourseWebDTO> listDTO = list.map(khoaHocMapper::toCourseWebDTOFromCourse).getContent();

        return listDTO;
    }

    @Override
    public List<CourseWebDTO> getListCourse(GetListCourseOnWebParam p) {

        Pageable pageable = PageRequest.of(p.getPageNo() - 1, p.getPageSize(), Sort.by("ID").descending());

        TrangThai s= trangThaiRepository.findByID(1);
        Page<KhoaHoc> list = khoaHocRepository.findByCourseByName(pageable,p.getName(),s);

        List<CourseWebDTO> listDTO = list.map(khoaHocMapper::toCourseWebDTOFromCourse).getContent();

        return listDTO;

    }

    @Override
    public List<KhoaHocResponeRegister> getAllTrangThaiEnable() {

        TrangThai trangThai = trangThaiRepository.findByID(1);

        final List<KhoaHoc> khoaHocs = khoaHocRepository.findAllByTrangThaiEnable(trangThai);

        final List<KhoaHocResponeRegister> khoaHocResponeRegisters = khoaHocMapper.toKhoaHocResponeRegisterFromKhoaHocs(khoaHocs);

        return khoaHocResponeRegisters;
    }


    @Override
    public List<KhoaHoc> findByCondition(String maKhoaHoc, String tenKhoaHoc, String ngayBatDau,
                                         String ngayKetThuc, Integer trangThai, Integer pageNo, Integer pageSize) {

        //chuyen doi thoi gian tu String qua TimeStamp
        Timestamp dateFrom, dateTo;

        if (ngayBatDau == null || ngayBatDau == "") {
            dateFrom = null;
        } else {
            dateFrom = paresStringToTimeStamp.paresStringToTimeStamp(ngayBatDau);
        }

        if (ngayKetThuc == null || ngayKetThuc == "") {
            dateTo = null;
        } else {
            dateTo = paresStringToTimeStamp.paresStringToTimeStamp(ngayKetThuc);
        }


        Pageable pageable = PageRequest.of(pageNo == null ? 0 : pageNo, pageSize == null ? 0 : 10,
                Sort.by("ID").descending());

        Page<KhoaHoc> list = khoaHocRepository.findByCondition(dateFrom, dateTo, maKhoaHoc,
                tenKhoaHoc, trangThaiRepository.findByID(trangThai), pageable);

        return list.toList();
    }

    @Override
    public KhoaHocRespone findByID(Long id) {
        return khoaHocMapper.toKhoaHocResponseFromKhoaHoc(

                khoaHocRepository.findByID(id)
        );
    }


    @Override
    public KhoaHoc findByCourseID(String courseID) {
        return khoaHocRepository.findByCourseID(courseID);
    }


    @Override
    public ActionDTO insert(KhoaHocRequest khoaHocRequest) {

        if (khoaHocRepository.findByCourseID(khoaHocRequest.getMaKhoaHoc()) != null) {
            throw new GeneralException(RESPONSE.CODE.C409,
                    RESPONSE.MESSAGE.C409_COURSE);
        }

        KhoaHoc newKhoaHoc = new KhoaHoc();

        BeanUtils.copyProperties(khoaHocRequest, newKhoaHoc);

        newKhoaHoc.setNgayBatDau(paresStringToTimeStamp.

                paresStringToTimeStamp(

                        khoaHocRequest.getNgayBatDau()
                )
        );

        newKhoaHoc.setNgayKetThuc(paresStringToTimeStamp.paresStringToTimeStamp(khoaHocRequest.getNgayKetThuc()));

        newKhoaHoc.setTrangThai(trangThaiRepository.findByID(khoaHocRequest.getTrangThai()));

        newKhoaHoc.setNguoiSua(Constant.INFO_DEFAULT);

        newKhoaHoc.setNgayTao(new Timestamp(System.currentTimeMillis()));

        newKhoaHoc.setNgaySua(Constant.DATE_DEFAULT);

        newKhoaHoc = khoaHocRepository.save(newKhoaHoc);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, newKhoaHoc.getID())
                .build()
        );
    }

    @Override
    public ActionDTO update(KhoaHocRequest khoaHocRequest) {

        KhoaHoc newKhoaHoc = new KhoaHoc();

        KhoaHoc old = khoaHocRepository.findByID(khoaHocRequest.getId());

        if (old == null) {
            throw new GeneralException(RESPONSE.CODE.C404,
                    RESPONSE.MESSAGE.C409_COURSE);
        }

        BeanUtils.copyProperties(khoaHocRequest, newKhoaHoc);

        newKhoaHoc.setID(khoaHocRequest.getId());

        newKhoaHoc.setNgayTao(old.getNgayTao());


        newKhoaHoc.setNgayBatDau(paresStringToTimeStamp.
                paresStringToTimeStamp(khoaHocRequest.getNgayBatDau()));

        newKhoaHoc.setNgayKetThuc(paresStringToTimeStamp.
                paresStringToTimeStamp(khoaHocRequest.getNgayKetThuc()));

        newKhoaHoc.setTrangThai(trangThaiRepository.
                findByID(khoaHocRequest.getTrangThai()));

        newKhoaHoc.setNgaySua(new Timestamp(System.currentTimeMillis()));

        newKhoaHoc = khoaHocRepository.save(newKhoaHoc);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, newKhoaHoc.getID())
                .build()
        );
    }

    @Override
    public ActionDTO delete(Long id) {

        if (khoaHocRepository.findByID(id) == null) {

            throw new GeneralException(RESPONSE.CODE.C404,
                    RESPONSE.MESSAGE.C409_COURSE);
        }

        khoaHocRepository.deleteById(id);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, id)
                .build()
        );
    }


    @Override
    public void deleteCutom(Long[] ids) {

    }

    @Override
    public Boolean checkCodeExists(String code) {

        KhoaHoc khoaHoc = khoaHocRepository.checkCodeExists(code);
        if (khoaHoc != null) return true;
        return false;
    }

    @Override
    public List<StudentDTO> getListStudentEnroll(Long id) {

        KhoaHoc khoaHoc = khoaHocRepository.findById(id).orElseThrow(
                () -> new GeneralException(RESPONSE.CODE.C404,
                        RESPONSE.MESSAGE.C404_COURSE)
        );

        List<SinhVienDangKi> list = new ArrayList<>();

        for (SinhVienDangKi i : khoaHoc.getSinhVienDangKiList()) {
            list.add(i);
        }
        return studentMapper.toStudentDTOFromStudents(list);

    }

    @Override
    public byte[] exportExcel() {

        final ExcelRequest excelRequest = ExcelRequest.builder()
                .fileName("Danh-sach-khoa-hoc")
                .sheetName("Export")
                .columnsTitle(Lists.newArrayList(
                        "STT",
                        "Mã khóa học",
                        "Tên khóa học",
                        "Mô tả",
                        "Học phí",
                        "Ngày Tạo",
                        "Người tạo",
                        "Ngày bắt đầu",
                        "Ngày kết thúc",
                        "Trạng thái"
                ))
                .columnsWidth(Lists.newArrayList(10, 20, 30, 50, 20, 20, 20, 20, 20, 20))
                .build();

        final List<KhoaHoc> khoaHocs = khoaHocRepository.findAll();

        List<Object[]> data = Lists.newArrayListWithCapacity(khoaHocs.size());

        for (int i = 0; i < khoaHocs.size(); i++) {

            final KhoaHoc khoaHoc = khoaHocs.get(i);

            Object[] objects = new Object[excelRequest.getColumnsTitle().size()];

            objects[0] = i + 1;
            objects[1] = khoaHoc.getMaKhoaHoc();
            objects[2] = khoaHoc.getTenKhoaHoc();
            objects[3] = khoaHoc.getMoTa();
            objects[4] = khoaHoc.getHocPhi().toString();
            objects[5] = khoaHoc.getNgayTao().toString();
            objects[6] = khoaHoc.getNguoiTao();
            objects[7] = khoaHoc.getNgayBatDau().toString();
            objects[8] = khoaHoc.getNgayKetThuc().toString();
            objects[9] = khoaHoc.getTrangThai().getTrangThai();

            data.add(objects);
        }
        return excelServices.write(excelRequest, data);
    }


}
