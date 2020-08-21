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
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.entity.*;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.exception.InfomationEmptyException;
import vn.tuyensinh.hoctiengviet.model.request.ExcelRequest;
import vn.tuyensinh.hoctiengviet.model.request.SinhVienRegister;
import vn.tuyensinh.hoctiengviet.repository.*;
import vn.tuyensinh.hoctiengviet.services.SinhVienDangKiService;
import vn.tuyensinh.hoctiengviet.util.Constant;
import vn.tuyensinh.hoctiengviet.util.ParesStringToTimeStamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SinhVienDangKiServiceImpl implements SinhVienDangKiService {
    @Autowired
    private SinhVienDangKiRepository sinhVienDangKiRepository;
    @Autowired
    private GioiTinhRepository gioiTinhRepository;

    @Autowired
    private DoiTuongUuTienRepository doiTuongUuTienRepository;

    @Autowired
    private LoaiHocBongRepository loaiHocBongRepository;

    @Autowired
    private NguoiLienHeKhanCapRepository nguoiLienHeKhanCapRepository;

    @Autowired
    private ThanhTichHocTapRepository thanhTichHocTapRepository;

    @Autowired
    private KhoaHocRepository khoaHocRepository;

    @Autowired
    private NgoaiNguRepository ngoaiNguRepository;

    @Autowired
    private ThanNhanRepoisitory thanNhanRepoisitory;

    @Autowired
    private HeDaoTaoRepository heDaoTaoRepository;

    @Autowired
    private ExcelServicesImpl excelServices;

    @Autowired
    private ParesStringToTimeStamp paresStringToTimeStamp;


    @Override
    public List<SinhVienDangKi> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("ID").descending());
        Page<SinhVienDangKi> list = sinhVienDangKiRepository.findAll(pageable);
        return list.toList();
    }

    @Override
    public SinhVienDangKi findByID(Long id) {
        return sinhVienDangKiRepository.findByID(id);
    }

    @Override
    public SinhVienDangKi findByPassport(String passport) {
        return sinhVienDangKiRepository.findByPassport(passport);
    }

    @Override
    public ActionDTO insert(SinhVienRegister sinhVienRegister) throws InfomationEmptyException {


        //chua xử sinh viên đnag kí 2 lần 1 khóa học trong cungdf 1 thời gian
            SinhVienDangKi newStudent = new SinhVienDangKi();

            BeanUtils.copyProperties(sinhVienRegister, newStudent);

            newStudent.setNgaySinh(

                    paresStringToTimeStamp.
                            paresStringToTimeStamp(
                                    sinhVienRegister.getNgaySinh()
                            )
            );

            newStudent.setGioiTinh(gioiTinhRepository.
                    findByID(sinhVienRegister.getGioiTinh()));

            newStudent.setDoiTuongUuTien(doiTuongUuTienRepository.
                    findByID(sinhVienRegister.getDoiTuongUuTien()));

            newStudent.setLoaiHocBong(loaiHocBongRepository.
                    findByID(sinhVienRegister.getLoaiHocBong()));

            newStudent.setNgayTao(new Timestamp(System.currentTimeMillis()));

            newStudent.setHeDaoTao(heDaoTaoRepository.findByID(sinhVienRegister.getHeDaoTao()));

            /** khoa hoc da co ID trc nen khong can tu sinh ra tronh bang khoa hoc */
            KhoaHoc khoaHoc = khoaHocRepository.findByID(sinhVienRegister.getMaKhoaHoc());

            Set<KhoaHoc> khoaHocSet = new HashSet<>();
            khoaHocSet.add(khoaHoc);

            newStudent.setKhoaHocList(khoaHocSet);

/**      than nhan chua co ID nen no dc coi la chua ton tai va tu dong dc cascade.all them vao trong bang than nhan*/
            Set<ThanNhan> thanNhanSet = sinhVienRegister.getListThanNhan();

            newStudent.setThanNhanList(thanNhanSet);

            SinhVienDangKi sv = sinhVienDangKiRepository.saveAndFlush(newStudent);

            /** 3 bang nay ko dc set trong khi khoi tao sinh vien de them vao DB cause:
             khong luu ma dinh danh(id) cua cac filed nay trong bang sinh vien de giam tai viec luu du lieu trong bang SV
             de tien truy xuat khi xac dinh thong tin trong bang ket qua hoc tap */

            ThanhTichHocTap newThanhTich = sinhVienRegister.getThanhTichHocTap();
            newThanhTich.setMaSinhVien(sv);

            thanhTichHocTapRepository.save(newThanhTich);

            NguoiLienHeKhanCap newNguoiLienHe = sinhVienRegister.getNguoiLienHeKhanCap();

            newNguoiLienHe.setMaSinhVien(sv);

            nguoiLienHeKhanCapRepository.save(newNguoiLienHe);

            sinhVienRegister.getNgoaiNguList().forEach(obj -> {

                obj.setSinhVienDangKi(sv);
                ngoaiNguRepository.save(obj);
            });

            return new ActionDTO(ImmutableMap.builder()
                    .put(Constant.RESPONSE.JSON_VALUE.VALUE_RETURN,sv.getID())
                    .build()
            );
    }

    @Override
    public ActionDTO  delete(Long id) {

        SinhVienDangKi oldStudent = sinhVienDangKiRepository.findByID(id);

        if (oldStudent == null) throw new GeneralException(Constant.RESPONSE.CODE.C404,
                Constant.RESPONSE.MESSAGE.C404_STUDENT);

        //xoa thanh tich cua sinh vien
        ThanhTichHocTap newTT = thanhTichHocTapRepository.findByStudentID(oldStudent);
        if (newTT != null) {
            thanhTichHocTapRepository.delete(newTT);
        }

        //xoa nguoi lien he cua sinh vien
        NguoiLienHeKhanCap newPerson = nguoiLienHeKhanCapRepository.findByStudent(oldStudent);
        if (newPerson != null) {
            nguoiLienHeKhanCapRepository.delete(newPerson);
        }

        //xoa danh sach thanh tich ngoai ngu cua sinh vien
        Set<NgoaiNgu> newSet = oldStudent.getNgoaiNguList();
        if (newSet.isEmpty() == false) {
            newSet.forEach(obj -> {
                ngoaiNguRepository.delete(obj);
            });
        }

        //xoa sinh vien
        sinhVienDangKiRepository.deleteById(id);

        return new ActionDTO(ImmutableMap.builder()
                .put(Constant.RESPONSE.JSON_VALUE.VALUE_RETURN,id)
                .build()
        );
    }

    @Override
    public ActionDTO deleteMany(Long[] ids) {

        for( Long i : ids) {

            delete(i);
        }
        return new ActionDTO(ImmutableMap.builder()
                .put(Constant.RESPONSE.JSON_VALUE.VALUE_RETURN,ids)
                .build()
        );
    }

    @Override
    public List<SinhVienDangKi> findByCondition(String hoVaTen, Integer gioiTinh, String quocGia,
                                                Integer doiTuongUuTien, Integer kieuHocBong, Integer heDaoTao,
                                                String noiHoc, Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("ID").descending());

        Page<SinhVienDangKi> list = sinhVienDangKiRepository.findByCondition(
                hoVaTen,
                gioiTinhRepository.findByID(gioiTinh),
                quocGia,
                doiTuongUuTienRepository.findByID(doiTuongUuTien),
                loaiHocBongRepository.findByID(kieuHocBong),
                heDaoTaoRepository.findByID(heDaoTao),
                noiHoc,
                pageable);

        return list.toList();
    }

    @Override
    public byte[] exportExcel() {
        final ExcelRequest excelRequest = ExcelRequest.builder()
                .fileName("Danh-sach-sinh-vien-dang-ki")
                .sheetName("Export")
                .columnsTitle(Lists.newArrayList(
                        "STT",
                        "Họ và tên",
                        "Số hộ chiếu",
                        "Ngày sinh",
                        "Giới tính",
                        "Quốc gia",
                        "Nơi sinh",
                        "Địa chỉ",
                        "Số điện thoại",
                        "Email",
                        "Fax",
                        "Khóa học",
                        "Hệ đào tạo",
                        "Niên khóa",
                        "Nơi học",
                        "Đối tượng ưu tiên",
                        "Loại học bổng",
                        "Ngày tạo"

                ))
                .columnsWidth(Lists.newArrayList(10, 30, 20, 20, 10, 20, 20, 20, 20, 50, 20, 80, 15, 20, 45, 30, 30, 30))
                .build();

        final List<SinhVienDangKi> sinhVienDangKis = sinhVienDangKiRepository.findAll();

        List<Object[]> data = Lists.newArrayListWithCapacity(sinhVienDangKis.size());

        for (int i = 0; i < sinhVienDangKis.size(); i++) {

            final SinhVienDangKi sinhVienDangKi = sinhVienDangKis.get(i);

            Object[] objects = new Object[excelRequest.getColumnsTitle().size()];

            objects[0] = i + 1;
            objects[1] = sinhVienDangKi.getHoVaTen();
            objects[2] = sinhVienDangKi.getSoHoChieu();
            objects[3] = sinhVienDangKi.getNgaySinh().toString();
            objects[4] = sinhVienDangKi.getGioiTinh().getGioiTinh();
            objects[5] = sinhVienDangKi.getQuocGia();
            objects[6] = sinhVienDangKi.getNoiSinh();
            objects[7] = sinhVienDangKi.getDiaChi();
            objects[8] = sinhVienDangKi.getSoDienThoai();
            objects[9] = sinhVienDangKi.getEmail();
            objects[10] = sinhVienDangKi.getFax();

            Object array[] = sinhVienDangKi.getKhoaHocList().toArray();
            KhoaHoc khoaHoc = (KhoaHoc) array[array.length - 1];
            objects[11] = khoaHoc.getTenKhoaHoc();

            objects[12] = sinhVienDangKi.getHeDaoTao().getTenHeDaoTao();
            objects[13] = sinhVienDangKi.getNienKhoa().toString();
            objects[14] = sinhVienDangKi.getNoiHoc();
            objects[15] = sinhVienDangKi.getDoiTuongUuTien().getLoaiUuTien();
            objects[16] = sinhVienDangKi.getLoaiHocBong().getLoaiHocBong();
            objects[17] = sinhVienDangKi.getNgayTao().toString();

            data.add(objects);
        }
        return excelServices.write(excelRequest, data);
    }
}
