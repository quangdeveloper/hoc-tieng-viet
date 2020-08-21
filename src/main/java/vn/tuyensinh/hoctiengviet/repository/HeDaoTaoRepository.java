package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.entity.HeDaoTao;

public interface HeDaoTaoRepository extends JpaRepository<HeDaoTao,Integer> {

    @Query("select u from HeDaoTao u")
    Page<HeDaoTao> findAll(Pageable pageable);

    @Query("select u from HeDaoTao u where u.ID = :id")
    HeDaoTao findByID(Integer id);

    @Query("select u from HeDaoTao u where u.maHeDaoTao = :maHeDaoTao")
    HeDaoTao findByID(String maHeDaoTao);





}
