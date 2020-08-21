package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.CoSoDaoTao;
import vn.tuyensinh.hoctiengviet.mapper.CoSoDaoTaoMapper;
import vn.tuyensinh.hoctiengviet.model.response.CoSoDaoTaoResponse;
import vn.tuyensinh.hoctiengviet.repository.CoSoDaoTaoRepository;

import java.util.List;

@Service
public class CoSoDaoTaoServicesImpl {

    @Autowired
    private CoSoDaoTaoRepository coSoDaoTaoRepository;

    @Autowired
    private CoSoDaoTaoMapper coSoDaoTaoMapper;

    public List<CoSoDaoTao> findAll(){

        return coSoDaoTaoRepository.findAll();
    }

    public CoSoDaoTao findByID(Integer id){

        return coSoDaoTaoRepository.findByID(id);
    }

    public List<CoSoDaoTaoResponse> getAll(){

        List<CoSoDaoTaoResponse> list = coSoDaoTaoMapper
                       .toCoSoDaoTaoResponseFromCoSoDaoTaos(coSoDaoTaoRepository.findAll());

        return list;
    }


}

