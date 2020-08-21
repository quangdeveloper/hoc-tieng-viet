package vn.tuyensinh.hoctiengviet.services;

import vn.tuyensinh.hoctiengviet.entity.TrangThai;

import java.util.List;

public interface TrangThaiService {

    List<TrangThai> findAll();

    void insert(TrangThai tt);

    void update(TrangThai tt);

    void remove(Integer id);

    TrangThai findByTrangThai(String tt);
    TrangThai findByID(Integer id);
}
