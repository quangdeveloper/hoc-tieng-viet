package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.DoiTuongUuTien;

import java.util.List;

public interface DoiTuongUuTienRepository extends JpaRepository<DoiTuongUuTien, Integer> {
    @Query("select a from DoiTuongUuTien a")
    List<DoiTuongUuTien> findAll();

    @Query("select a from DoiTuongUuTien a where a.loaiUuTien = :type")
    DoiTuongUuTien findByTypePriorities(@Param("type") String type);

    @Query("select a from DoiTuongUuTien a where a.ID = :id")
    DoiTuongUuTien findByID(@Param("id") Integer id);


}
