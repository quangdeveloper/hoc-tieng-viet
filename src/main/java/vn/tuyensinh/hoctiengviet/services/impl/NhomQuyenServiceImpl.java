package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.NhomQuyen;
import vn.tuyensinh.hoctiengviet.repository.NhomQuyenRepository;
import vn.tuyensinh.hoctiengviet.services.NhomQuyenService;

import java.util.List;

@Service
public class NhomQuyenServiceImpl implements NhomQuyenService {


    @Autowired
    private NhomQuyenRepository nhomQuyenRepository;

    @Override
    public List<NhomQuyen> findAll() {
        return nhomQuyenRepository.findAll();
    }
}
