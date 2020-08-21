package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;
import vn.tuyensinh.hoctiengviet.repository.GioiTinhRepository;
import vn.tuyensinh.hoctiengviet.services.GioiTinhService;

import java.util.List;

@Service
public class GioiTinhServiceImpl implements GioiTinhService {
    @Autowired
    private GioiTinhRepository gioiTinhRepository;
    @Override
    public List<GioiTinh> findAll() {
        return gioiTinhRepository.findAll();
    }

    @Override
    public GioiTinh findByGender(String type) {
        return null;
    }

    @Override
    public GioiTinh findByID(Integer id) {
       return gioiTinhRepository.findByID(id);
    }
}
