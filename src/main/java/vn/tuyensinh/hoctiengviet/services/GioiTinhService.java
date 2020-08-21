package vn.tuyensinh.hoctiengviet.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface GioiTinhService {
    List<GioiTinh> findAll();
    GioiTinh findByGender(@Param("type") String type);
    GioiTinh findByID(@Param("id") Integer id);
}
