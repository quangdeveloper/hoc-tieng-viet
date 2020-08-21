package vn.tuyensinh.hoctiengviet.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.LoaiHocBong;

import java.util.List;

public interface LoaiHocBongService {
    List<LoaiHocBong> findAll();
    LoaiHocBong findByScholarship(@Param("type") String type);
    LoaiHocBong findByID(@Param("id") Integer id);
}
