package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.LoaiHocBong;
import vn.tuyensinh.hoctiengviet.repository.LoaiHocBongRepository;
import vn.tuyensinh.hoctiengviet.services.LoaiHocBongService;

import java.util.List;

@Service
public class LoaiHocBongServiceImpl implements LoaiHocBongService {
    @Autowired
    private LoaiHocBongRepository loaiHocBongRepository;
    @Override
    public List<LoaiHocBong> findAll() {
        return loaiHocBongRepository.findAll();
    }

    @Override
    public LoaiHocBong findByScholarship(String type) {
        return loaiHocBongRepository.findByScholarship(type);
    }

    @Override
    public LoaiHocBong findByID(Integer id) {
        return loaiHocBongRepository.findByID(id);
    }
}
