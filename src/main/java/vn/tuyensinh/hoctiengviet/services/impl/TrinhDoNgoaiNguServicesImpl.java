package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.TrinhDoNgoaiNgu;
import vn.tuyensinh.hoctiengviet.repository.TrinhDoNgoaiNguRepository;

import java.util.List;

@Service
public class TrinhDoNgoaiNguServicesImpl {

    @Autowired
    private TrinhDoNgoaiNguRepository trinhDoNgoaiNguRepository;

    public List<TrinhDoNgoaiNgu> findAll(){
        return trinhDoNgoaiNguRepository.findAll();
    }


}
