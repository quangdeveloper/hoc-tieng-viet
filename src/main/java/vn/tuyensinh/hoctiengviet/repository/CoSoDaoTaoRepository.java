package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tuyensinh.hoctiengviet.entity.CoSoDaoTao;

import java.util.List;

public interface CoSoDaoTaoRepository extends JpaRepository<CoSoDaoTao,Integer> {

    @Query("select u from CoSoDaoTao u")
    List<CoSoDaoTao> findAll();

    @Query("select u from CoSoDaoTao u where u.ID = :id")
    CoSoDaoTao findByID(Integer id);

}
