package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.entity.ThanhTichHocTap;
import vn.tuyensinh.hoctiengviet.repository.SinhVienDangKiRepository;
import vn.tuyensinh.hoctiengviet.repository.ThanhTichHocTapRepository;
import vn.tuyensinh.hoctiengviet.services.ThanhTichHocTapService;

import java.util.List;
@Service
public class ThanhTichHocTapServiceImpl implements ThanhTichHocTapService {

    @Autowired
    private ThanhTichHocTapRepository thanhTichHocTapRepository;

    @Autowired
    private SinhVienDangKiRepository sinhVienDangKiRepository;

    @Override
    public List<ThanhTichHocTap> findAll() {
        return thanhTichHocTapRepository.findAll();
    }

    @Override
    public ThanhTichHocTap findByID(Long id) {
        return thanhTichHocTapRepository.findByID(id);
    }

    @Override
    public ThanhTichHocTap findByStudentID(Long id) {

        SinhVienDangKi sv = sinhVienDangKiRepository.findByID(id);

        return thanhTichHocTapRepository.findByStudentID(sv);
    }

    @Override
    public void delete(Long id) {
        thanhTichHocTapRepository.deleteById(id);
    }


}
