package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;
import vn.tuyensinh.hoctiengviet.entity.KhoaHoc;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;

import java.sql.Timestamp;
import java.util.List;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan,Long> {
    @Query("select u from TaiKhoan u")
    Page<TaiKhoan> findAll(Pageable pageable);

    @Query("select u from TaiKhoan u where u.ID = :id")
    TaiKhoan findByID(@Param("id")Long id);

    @Query("select u from TaiKhoan  u  where u.taiKhoan = :tk")
    TaiKhoan findByTaiKhoan(@Param("tk")String tk);

    @Query("SELECT u FROM TaiKhoan u WHERE (:ngayBatDau IS NULL OR u.ngayTao >= :ngayBatDau)" +
            "AND (:ngayKetThuc IS NULL OR u.ngayTao <= :ngayKetThuc)" +
            "AND (:hoVaTen IS NULL OR u.hoVaTen like %:hoVaTen%)" +
            "AND (:taiKhoan IS NULL OR u.taiKhoan like %:taiKhoan%)" +
            "AND (:soDienThoai IS NULL OR u.soDienThoai like %:soDienThoai%)" +
            "AND (:email IS NULL OR u.email like %:email%)" +
            "AND (:nguoiTao IS NULL OR u.nguoiTao like %:nguoiTao%)" +
            "AND (:gioiTinh IS NULL OR u.gioiTinh = :gioiTinh)" +
            "AND (:status IS NULL OR u.trangThai = :status)")
    Page<TaiKhoan> findByCondition(@Param("ngayBatDau") Timestamp ngayBatDau,
                                  @Param("ngayKetThuc") Timestamp ngayKetThuc,
                                  @Param("hoVaTen") String hoVaTen,
                                  @Param("taiKhoan") String taiKhoan,
                                  @Param("soDienThoai") String soDienThoai,
                                  @Param("email") String email,
                                  @Param("nguoiTao") String nguoiTao,
                                  @Param("gioiTinh") GioiTinh gioiTinh,
                                  @Param("status") TrangThai status,
                                  Pageable pageable);

}
