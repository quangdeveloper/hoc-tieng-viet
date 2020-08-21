package vn.tuyensinh.hoctiengviet.services.impl;


import com.google.common.collect.ImmutableMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.constant.Constant;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.mapper.GiangVienMapper;
import vn.tuyensinh.hoctiengviet.model.request.GiangVienRequest;
import vn.tuyensinh.hoctiengviet.model.response.GiangVienResponse;
import vn.tuyensinh.hoctiengviet.repository.GiangVienRepository;
import vn.tuyensinh.hoctiengviet.repository.GioiTinhRepository;
import vn.tuyensinh.hoctiengviet.services.GiangVienService;
import vn.tuyensinh.hoctiengviet.util.ParesStringToTimeStamp;
import vn.tuyensinh.hoctiengviet.util.Constant.Date;

import java.sql.Timestamp;
import java.util.List;

import vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE;

@Service
public class GiangVienServiceImpl implements GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private ParesStringToTimeStamp paresStringToTimeStamp;

    @Autowired
    private GioiTinhRepository gioiTinhRepository;

    @Autowired
    private GiangVienMapper giangVienMapper;

    @Override
    public List<GiangVien> findAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());

        Page<GiangVien> list = giangVienRepository.findAll(pageable);

        return list.toList();
    }

    @Override
    public GiangVien findByLectureCode(String code) {

        return giangVienRepository.findByLectureCode(code);
    }

    @Override
    public GiangVienResponse findByLectureID(Long gvid) {

        return giangVienMapper.toGiangVienResponseFromGiangVien(

                giangVienRepository.findByID(gvid)
        );
    }

    @Override
    public List<GiangVien> searchCondiTion(String ngayBatDau, String ngayKetThuc, String hoVaTen,
                                           String maGiangVien, String diaChi, String noiSinh, String soDienThoai,
                                           String email, Integer gioiTinh, Integer pageNo, Integer pageSize) {


        //chuyen doi thoi gian tu String qua TimeStamp
        Timestamp dateFrom, dateTo;

        if (ngayBatDau == null || ngayBatDau == "") {
            dateFrom = Constant.DATE_DEFAULT;
        } else {
            dateFrom = paresStringToTimeStamp.paresStringToTimeStamp(ngayBatDau);
        }

        if (ngayKetThuc == null || ngayKetThuc == "") {
            dateTo = Constant.CURRENT_DATE_DEFAULT;
        } else {
            dateTo = paresStringToTimeStamp.paresStringToTimeStamp(ngayKetThuc);
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());

        Page<GiangVien> list = giangVienRepository.searchCondition(
                dateFrom, dateTo, hoVaTen, maGiangVien, diaChi, noiSinh, soDienThoai,
                email, gioiTinhRepository.findByID(gioiTinh), pageable);

        return list.toList();

    }


    @Override
    public ActionDTO insert(GiangVienRequest gv) {

        if (giangVienRepository.findByLectureCode(gv.getMaGiangVien()) != null) {

            throw new GeneralException(RESPONSE.CODE.C409, RESPONSE.MESSAGE.C409_LECTURE);
        }

        GiangVien giangVien = new GiangVien();

        BeanUtils.copyProperties(gv, giangVien);

        giangVien.setNgayBatDau(
                paresStringToTimeStamp.paresStringToTimeStamp(
                        gv.getNgayBatDau() == null ? Date.DATE_DEFAULT : gv.getNgayBatDau()
                )

        );

        giangVien.setNgayKetThuc(
                paresStringToTimeStamp.paresStringToTimeStamp(
                        gv.getNgayKetThuc() == null ? Date.DATE_DEFAULT : gv.getNgayKetThuc()
                )
        );

        giangVien.setGioiTinh(gioiTinhRepository.findByID(gv.getGioiTinh()));

        giangVien = giangVienRepository.save(giangVien);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, giangVien.getId())
                .build()
        );
    }

    @Override
    public ActionDTO update(GiangVienRequest gv) {

        GiangVien giangVien = new GiangVien();

        if (giangVienRepository.findByID(gv.getId()) == null) {

            throw new GeneralException(RESPONSE.CODE.C404, RESPONSE.MESSAGE.C404_LECTURE);
        }

        BeanUtils.copyProperties(gv, giangVien);

        giangVien.setNgayBatDau(
                paresStringToTimeStamp.paresStringToTimeStamp(
                        gv.getNgayBatDau() == null ? Date.DATE_DEFAULT : gv.getNgayBatDau()
                )

        );

        giangVien.setNgayKetThuc(
                paresStringToTimeStamp.paresStringToTimeStamp(
                        gv.getNgayKetThuc() == null ? Date.DATE_DEFAULT : gv.getNgayKetThuc()
                )
        );

        giangVien.setGioiTinh(gioiTinhRepository.findByID(gv.getGioiTinh()));

        giangVien = giangVienRepository.save(giangVien);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, giangVien.getId())
                .build()
        );
    }

    @Override
    public  ActionDTO delete(Long id) {

        if (giangVienRepository.findByID(id) == null) {

            throw new GeneralException(RESPONSE.CODE.C404, RESPONSE.MESSAGE.C404_LECTURE);
        }

        giangVienRepository.deleteById(id);

        return new ActionDTO( ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, id)
                .build()
        );
    }



    @Override
    public ActionDTO deleteMany(Long[] ids) {

        for (Long i : ids){

            delete(i);
        }
        return new ActionDTO( ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, ids)
                .build()
        );
    }

    @Override
    public List<GiangVien> findByStartDateAndAdrress(String fromDate, String toDate, String address) {

        Timestamp dateFrom, dateTo;

        if (fromDate == null || fromDate == "") {
            dateFrom = Constant.DATE_DEFAULT;
        } else {
            dateFrom = paresStringToTimeStamp.paresStringToTimeStamp(fromDate);
        }

        if (toDate == null || toDate == "") {
            dateTo = Constant.CURRENT_DATE_DEFAULT;
        } else {
            dateTo = paresStringToTimeStamp.paresStringToTimeStamp(toDate);
        }

        return giangVienRepository.findByStartDateAndAddress(dateFrom, dateTo, address);
    }
}
