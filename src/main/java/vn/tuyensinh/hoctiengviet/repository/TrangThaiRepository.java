package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;

import java.util.List;

public interface TrangThaiRepository extends JpaRepository<TrangThai, Integer> {

    @Query("select a from TrangThai a")
    List<TrangThai> findAll();

    @Query("select a from TrangThai  a where a.trangThai = :trangThai")
    TrangThai findByTrangThai(@Param("trangThai") String trangThai);

    @Query("select a from TrangThai  a where a.ID = :id")
    TrangThai findByID(@Param("id") Integer id);
}
