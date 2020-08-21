package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.DoiTuongUuTien;
import vn.tuyensinh.hoctiengviet.model.request.DoiTuongUuTienRequest;
import vn.tuyensinh.hoctiengviet.repository.DoiTuongUuTienRepository;
import vn.tuyensinh.hoctiengviet.services.DoiTuongUuTienService;

import java.util.List;
@Service
public class DoiTuongUuTienServiceImpl implements DoiTuongUuTienService {
    @Autowired
    private DoiTuongUuTienRepository doiTuongUuTienRepository;
    @Override
    public List<DoiTuongUuTien> findAll() {
        return doiTuongUuTienRepository.findAll();
    }

    @Override
    public void insert(DoiTuongUuTienRequest object) {
        DoiTuongUuTien newObject = new DoiTuongUuTien();
        newObject.setLoaiUuTien(object.getLoaiUuTien());
        doiTuongUuTienRepository.save(newObject);
    }

    @Override
    public void update(DoiTuongUuTienRequest object) {

        DoiTuongUuTien newObject = new DoiTuongUuTien();
        newObject.setID(object.getId());
        newObject.setLoaiUuTien(object.getLoaiUuTien());
        doiTuongUuTienRepository.save(newObject);
    }

    @Override
    public void delete(Integer id) {

        doiTuongUuTienRepository.deleteById(id);
    }

    @Override
    public DoiTuongUuTien findByTypePriorities(String type) {

        return doiTuongUuTienRepository.findByTypePriorities(type);
    }

    @Override
    public DoiTuongUuTien findByID(Integer id) {
        return doiTuongUuTienRepository.findByID(id);
    }


}
