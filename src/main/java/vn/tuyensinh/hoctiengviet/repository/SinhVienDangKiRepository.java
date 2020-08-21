package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.*;

import java.sql.Timestamp;
import java.util.List;

public interface SinhVienDangKiRepository extends JpaRepository<SinhVienDangKi,Long> {

    @Query("select a from  SinhVienDangKi  a")
    List<SinhVienDangKi> findAll();

    @Query("select a from  SinhVienDangKi  a where a.ID = :id")
    SinhVienDangKi findByID(Long id);

    @Query("select a from  SinhVienDangKi  a where a.soHoChieu = :passport")
    SinhVienDangKi findByPassport(@Param("passport") String passport);

    @Query("SELECT u FROM SinhVienDangKi u WHERE (:hoVaTen IS NULL OR u.hoVaTen like %:hoVaTen%)" +
            "AND (:gioiTinh IS NULL OR u.gioiTinh = :gioiTinh)" +
            "AND (:quocGia IS NULL OR u.quocGia like %:quocGia%)" +
            "AND (:doiTuongUuTien IS NULL OR u.doiTuongUuTien = :doiTuongUuTien)" +
            "AND (:kieuHocBong IS NULL OR u.loaiHocBong = :kieuHocBong)" +
            "AND (:heDaoTao IS NULL OR u.heDaoTao = :heDaoTao)" +
            "AND (:noiHoc IS NULL OR u.noiHoc like %:noiHoc%)")
    Page<SinhVienDangKi> findByCondition(String hoVaTen,
                                  GioiTinh gioiTinh,
                                  String quocGia,
                                  DoiTuongUuTien doiTuongUuTien,
                                  LoaiHocBong kieuHocBong,
                                  HeDaoTao heDaoTao,
                                  String noiHoc,
                                  Pageable pageable);
}
