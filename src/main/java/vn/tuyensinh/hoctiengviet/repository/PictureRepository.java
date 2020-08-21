package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tuyensinh.hoctiengviet.entity.Picture;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;

public interface PictureRepository extends JpaRepository<Picture,Long> {


    @Query("select u from Picture u where u.isActive = :b")
    Page<Picture> findByStatus(Pageable p,Boolean b);
    
    
}
