package vn.tuyensinh.hoctiengviet.services;

import vn.tuyensinh.hoctiengviet.entity.NguoiLienHeKhanCap;

import java.util.List;

public interface NguoiLienHeKhanCapService {

    List<NguoiLienHeKhanCap> findAll();

    NguoiLienHeKhanCap findByID(Long id);

    NguoiLienHeKhanCap findByStudentID(Long id);
}
