package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.NhomQuyen;
import vn.tuyensinh.hoctiengviet.entity.Quyen;

import java.util.List;

public interface QuyenRopository extends JpaRepository<Quyen,Integer> {

    @Query("select u from Quyen  u")
    List<Quyen> findAll();

    @Query("select u from Quyen u where u.ID = :id")
    Quyen findByID(@Param("id")Integer id);

    @Query("select u from Quyen u where u.tenQuyen = :name")
    Quyen findByNameRole(@Param("name")String name);

    @Query("select u from Quyen u  where (:tenQuyen is null or u.tenQuyen like %:tenQuyen%) " +
            "and (:nhomQuyen is null or u.nhomQuyen = :nhomQuyen)" +
            "and (:nguoiTao is null  or u.nguoiTao like %:nguoiTao%)")
    List<Quyen> searchCondition(String tenQuyen, NhomQuyen nhomQuyen, String nguoiTao);

}
