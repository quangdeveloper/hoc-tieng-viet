package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tuyensinh.hoctiengviet.entity.DanhMucBaiViet;

import java.util.List;


public interface DanhMucBaiVietRepository extends JpaRepository<DanhMucBaiViet,Integer> {


    @Query("select  u from DanhMucBaiViet  u where u.ID = :id")
    DanhMucBaiViet finbByID(Integer id);

    @Query("select  u from DanhMucBaiViet  u where u.maDanhMuc = :maDanhMuc")
    DanhMucBaiViet finbByCode(String maDanhMuc);

    @Query("select u from DanhMucBaiViet u where (:maDanhMuc is null or u.maDanhMuc like %:maDanhMuc%)" +
            "and (:tenDanhMuc is null or u.tenDanhMuc like %:tenDanhMuc%) order by ID DESC ")
    List<DanhMucBaiViet> searchCondition(String maDanhMuc, String tenDanhMuc);


}
