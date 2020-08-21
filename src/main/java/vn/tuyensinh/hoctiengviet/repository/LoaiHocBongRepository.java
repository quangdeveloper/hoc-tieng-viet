package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.LoaiHocBong;

import java.util.List;

public interface LoaiHocBongRepository extends JpaRepository<LoaiHocBong,Integer> {
    @Query("select a from LoaiHocBong a")
    List<LoaiHocBong> findAll();

    @Query("select a from LoaiHocBong a where a.loaiHocBong = :type")
    LoaiHocBong findByScholarship(@Param("type") String type);

    @Query("select a from LoaiHocBong a where a.id= :id")
    LoaiHocBong findByID(@Param("id") Integer id);
}
