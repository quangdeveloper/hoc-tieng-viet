package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.NgoaiNgu;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;

import java.util.List;

public interface NgoaiNguRepository extends JpaRepository<NgoaiNgu,Long> {
    @Query("select a from NgoaiNgu a")
    List<NgoaiNgu> findAll();

    @Query("select a from NgoaiNgu a where a.ID = :id")
    NgoaiNgu findByID(@Param("id") Long id);
}
