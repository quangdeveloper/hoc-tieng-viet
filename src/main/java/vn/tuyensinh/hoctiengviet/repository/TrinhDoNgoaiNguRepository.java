package vn.tuyensinh.hoctiengviet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tuyensinh.hoctiengviet.entity.TrinhDoNgoaiNgu;

import java.util.List;

public interface TrinhDoNgoaiNguRepository extends JpaRepository<TrinhDoNgoaiNgu,Integer> {

    @Query("select u from TrinhDoNgoaiNgu  u")
    List<TrinhDoNgoaiNgu> findAll();

    @Query("select u from TrinhDoNgoaiNgu  u where u.ID = :id")
    List<TrinhDoNgoaiNgu> findByID(Integer id);

}
