package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;
import vn.tuyensinh.hoctiengviet.repository.TrangThaiRepository;
import vn.tuyensinh.hoctiengviet.services.TrangThaiService;

import java.util.List;

@Service
public class TrangThaiServiceImpl implements TrangThaiService {
    @Autowired
    private TrangThaiRepository trangThaiRepository;


    @Override
    public List<TrangThai> findAll() {
        return trangThaiRepository.findAll();
    }

    @Override
    public void insert(TrangThai tt) {
        trangThaiRepository.save(tt);
    }

    @Override
    public void update(TrangThai tt) {
        trangThaiRepository.save(tt);
    }

    @Override
    public void remove(Integer id) {
        trangThaiRepository.deleteById(id);
    }

    @Override
    public TrangThai findByTrangThai(String tt) {

        return trangThaiRepository.findByTrangThai(tt);

    }

    @Override
    public TrangThai findByID(Integer id) {
        return  trangThaiRepository.findByID(id);
    }
}
