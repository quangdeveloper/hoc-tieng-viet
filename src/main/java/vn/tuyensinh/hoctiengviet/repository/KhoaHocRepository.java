package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.entity.KhoaHoc;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;

import java.sql.Timestamp;
import java.util.List;

public interface KhoaHocRepository extends JpaRepository<KhoaHoc, Long> {

    @Query("select a from KhoaHoc  a")
    List<KhoaHoc> findAll();

    @Query("select a from KhoaHoc  a where a.trangThai = :trangThai")
    List<KhoaHoc> findAllByTrangThaiEnable(TrangThai trangThai);

    @Query("select a from KhoaHoc a where a.ID = :id")
    KhoaHoc findByID(@Param("id") Long id);

    @Query("select a from KhoaHoc a where a.maKhoaHoc = :id")
    KhoaHoc findByCourseID(@Param("id") String id);

    @Query("select a from KhoaHoc  a where (:status is null or  a.trangThai = :status)")
    Page<KhoaHoc> findAllEnable(Pageable p,
                                @Param("status") TrangThai status);

    @Query("select a from KhoaHoc a where (:name is null or a.tenKhoaHoc like %:name%) " +
            "and(:status is null or  a.trangThai = :status)")
    Page<KhoaHoc> findByCourseByName(Pageable p,
                                     @Param("name") String name,
                                     @Param("status")TrangThai status);

    @Query("SELECT u FROM KhoaHoc u WHERE (:startDate IS NULL OR u.ngayBatDau >= :startDate)" +
            "AND (:endDate IS NULL OR u.ngayBatDau <= :endDate)" +
            "AND (:maKhoaHoc IS NULL OR u.maKhoaHoc like %:maKhoaHoc%)" +
            "AND (:tenKhoaHoc IS NULL OR u.tenKhoaHoc like %:tenKhoaHoc%)" +
            "AND (:status IS NULL OR u.trangThai = :status)")
    Page<KhoaHoc> findByCondition(@Param("startDate") Timestamp startDate,
                                  @Param("endDate") Timestamp endDate,
                                  @Param("maKhoaHoc") String maKhoaHoc,
                                  @Param("tenKhoaHoc") String tenKhoaHoc,
                                  @Param("status") TrangThai status,
                                  Pageable pageable);


    @Query("select a from KhoaHoc a where a.maKhoaHoc = :code")
    KhoaHoc checkCodeExists(@Param("code") String code);
}
