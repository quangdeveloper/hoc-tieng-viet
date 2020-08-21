package vn.tuyensinh.hoctiengviet.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.NgoaiNgu;

import java.util.List;

public interface NgoaiNguService {

    List<NgoaiNgu> findAll();
    NgoaiNgu findByID(Long id);
}
