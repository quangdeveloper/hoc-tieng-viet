package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.DoiTuongUuTien;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.entity.ThanhTichHocTap;

import java.util.List;

public interface ThanhTichHocTapRepository extends JpaRepository<ThanhTichHocTap, Long> {
    @Query("select a from ThanhTichHocTap a")
    List<ThanhTichHocTap> findAll();

    @Query("select a from ThanhTichHocTap a where a.ID = :id")
    ThanhTichHocTap findByID(@Param("id")Long id);

    // khi khai bao trong entity thuoc tinh la 1 doi tuong thi khi truy van cx phai truyen vao 1 doi tuong
    // tu hibernate se bounding thuoc tinh tim kiem
    @Query("select a from ThanhTichHocTap a where a.maSinhVien = :sv")
    ThanhTichHocTap findByStudentID(@Param("sv") SinhVienDangKi sv);

}
