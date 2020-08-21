package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface GiangVienRepository extends JpaRepository<GiangVien, Long> {
    @Query("select a from GiangVien a")
    List<GiangVien> findAll();

    @Query("select a from GiangVien a where a.maGiangVien = :code")
    GiangVien findByLectureCode(@Param("code") String code);

    @Query("select a from GiangVien a where a.id = :id")
    GiangVien findByID(@Param("id") Long id);

    @Query("SELECT u FROM GiangVien u WHERE (:fromDate IS NULL OR u.ngayBatDau >= :fromDate)" +
            "AND (:toDate IS NULL OR u.ngayBatDau <= :toDate)" +
            "AND (:address IS NULL OR u.diaChi = :address)")
    List<GiangVien> findByStartDateAndAddress(@Param("fromDate") Timestamp fromDate,
                                              @Param("toDate") Timestamp toDate,
                                              @Param("address") String address);


    @Query("SELECT u FROM GiangVien u WHERE (:ngayBatDau IS NULL OR u.ngayBatDau >= :ngayBatDau)" +
            "AND (:ngayKetThuc IS NULL OR u.ngayBatDau <= :ngayKetThuc)" +
            "AND (:hoVaTen IS NULL OR u.hoVaTen like %:hoVaTen%)" +
            "AND (:maGiangVien IS NULL OR u.maGiangVien like %:maGiangVien%)" +
            "AND (:diaChi IS NULL OR u.diaChi like %:diaChi%)" +
            "AND (:noiSinh IS NULL OR u.noiSinh like %:noiSinh%)" +
            "AND (:soDienThoai IS NULL OR u.soDienThoai like %:soDienThoai%)" +
            "AND (:email IS NULL OR u.email like %:email%)" +
            "AND (:gioiTinh IS NULL OR u.gioiTinh = :gioiTinh)")
    Page<GiangVien> searchCondition(@Param("ngayBatDau") Timestamp ngayBatDau,
                                    @Param("ngayKetThuc") Timestamp ngayKetThuc,
                                    @Param("hoVaTen") String hoVaTen,
                                    @Param("maGiangVien") String maGiangVien,
                                    @Param("diaChi") String diaChi,
                                    @Param("noiSinh") String noiSinh,
                                    @Param("soDienThoai") String soDienThoai,
                                    @Param("email") String email,
                                    @Param("gioiTinh") GioiTinh gioiTinh,
                                    Pageable pageable);


}
