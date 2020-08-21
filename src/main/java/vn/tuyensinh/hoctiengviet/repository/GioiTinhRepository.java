package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;

import java.util.List;

public interface GioiTinhRepository extends JpaRepository<GioiTinh,Integer> {
    @Query("select a from GioiTinh a")
    List<GioiTinh> findAll();

    @Query("select a from GioiTinh a where a.gioiTinh = :type")
   GioiTinh findByGender(@Param("type") String type);

    @Query("select a from GioiTinh a where a.id = :ids")
    GioiTinh findByID(@Param("ids") Integer ids);

}
