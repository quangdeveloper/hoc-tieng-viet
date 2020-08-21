package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.NhomQuyen;

import java.util.List;

public interface NhomQuyenRepository extends JpaRepository<NhomQuyen,Integer> {

    @Query("select u from NhomQuyen  u")
    List<NhomQuyen> findAll();
    @Query("select u from  NhomQuyen  u where u.ID = :id")
    NhomQuyen findByID(@Param("id")Integer id);
}
