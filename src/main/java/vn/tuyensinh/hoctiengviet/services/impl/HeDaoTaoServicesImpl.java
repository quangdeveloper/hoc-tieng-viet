package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.HeDaoTao;
import vn.tuyensinh.hoctiengviet.repository.HeDaoTaoRepository;

import java.util.List;

@Service
public class HeDaoTaoServicesImpl {

    @Autowired
    private HeDaoTaoRepository heDaoTaoRepository;

    public List<HeDaoTao> findAll(){

        return heDaoTaoRepository.findAll();
    }

    public HeDaoTao findByID(Integer id){

        return heDaoTaoRepository.findByID(id);
    }
}
