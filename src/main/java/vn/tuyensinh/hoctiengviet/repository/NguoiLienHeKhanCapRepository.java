package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.DoiTuongUuTien;
import vn.tuyensinh.hoctiengviet.entity.NguoiLienHeKhanCap;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.services.LoaiHocBongService;

import java.util.List;

public interface NguoiLienHeKhanCapRepository extends JpaRepository<NguoiLienHeKhanCap,Long> {
    @Query("select a from NguoiLienHeKhanCap a")
    List<NguoiLienHeKhanCap> findAll();

    @Query("select a from NguoiLienHeKhanCap a where a.maSinhVien = :obj")
    NguoiLienHeKhanCap findByStudent(@Param("obj")SinhVienDangKi obj);

    @Query("select a from NguoiLienHeKhanCap a where a.ID = :id")
    NguoiLienHeKhanCap findByID(@Param("id") Long id);



}
