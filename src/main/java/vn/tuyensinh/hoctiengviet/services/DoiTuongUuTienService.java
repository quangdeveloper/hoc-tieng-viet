package vn.tuyensinh.hoctiengviet.services;

import vn.tuyensinh.hoctiengviet.entity.DoiTuongUuTien;
import vn.tuyensinh.hoctiengviet.model.request.DoiTuongUuTienRequest;

import java.util.List;

public interface DoiTuongUuTienService {
    List<DoiTuongUuTien> findAll();
    void insert(DoiTuongUuTienRequest object);
    void update(DoiTuongUuTienRequest object);
    void delete(Integer id);
    DoiTuongUuTien findByTypePriorities(String type);
    DoiTuongUuTien findByID(Integer id);
}
