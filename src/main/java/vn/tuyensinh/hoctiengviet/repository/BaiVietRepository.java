package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.BaiViet;
import vn.tuyensinh.hoctiengviet.entity.DanhMucBaiViet;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;


import java.sql.Timestamp;
import java.util.List;

public interface BaiVietRepository extends JpaRepository<BaiViet,Long> {

    @Query("select u from BaiViet u where (:tieuDe is null or u.tieuDe like %:tieuDe%)" +
            "and (:tacGia is null or u.tacGia like %:tacGia% )" +
            "and (:danhMuc is null or u.danhMucBaiViet = :danhMuc)" +
            "and (:trangThai is null or u.trangThai = :trangThai)" +
            "and (:ngayTaoBD is null or u.ngayTao >= :ngayTaoBD)" +
            "and (:ngayTaoKT is null or u.ngayTao <= :ngayTaoKT)" +
            "and (:nguoiTao is null or u.nguoiTao like %:nguoiTao%)")
    Page<BaiViet> searchCondiTion(String tieuDe,
                                  String tacGia,
                                  DanhMucBaiViet danhMuc,
                                  TrangThai trangThai,
                                  Timestamp ngayTaoBD,
                                  Timestamp ngayTaoKT,
                                  String nguoiTao,
                                  Pageable pageable
                                  );

    @Query("select u from BaiViet u where u.danhMucBaiViet = :d")
    Page<BaiViet> searchByCategory(DanhMucBaiViet d,
                                   Pageable p);

    @Query("select u from BaiViet u where u.tacGia = :d")
    Page<BaiViet> searchByAuthor(String d,
                                 Pageable p);

    @Query("select u from BaiViet u where u.ID = :id")
    BaiViet findByID(Long id);

}
