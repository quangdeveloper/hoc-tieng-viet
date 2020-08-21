package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.NgoaiNgu;
import vn.tuyensinh.hoctiengviet.repository.NgoaiNguRepository;
import vn.tuyensinh.hoctiengviet.services.NgoaiNguService;

import java.util.List;

@Service
public class NgoaiNguServiceImpl implements NgoaiNguService {
    @Autowired
    private NgoaiNguRepository ngoaiNguRepository;

    @Override
    public List<NgoaiNgu> findAll() {
        return ngoaiNguRepository.findAll();
    }

    @Override
    public NgoaiNgu findByID(Long id) {
        return ngoaiNguRepository.findByID(id);
    }
}
