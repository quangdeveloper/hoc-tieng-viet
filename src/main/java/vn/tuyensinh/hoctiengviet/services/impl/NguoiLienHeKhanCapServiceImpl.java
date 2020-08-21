package vn.tuyensinh.hoctiengviet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.entity.NguoiLienHeKhanCap;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.repository.NguoiLienHeKhanCapRepository;
import vn.tuyensinh.hoctiengviet.repository.SinhVienDangKiRepository;
import vn.tuyensinh.hoctiengviet.services.NguoiLienHeKhanCapService;

import java.util.List;
@Service
public class NguoiLienHeKhanCapServiceImpl implements NguoiLienHeKhanCapService {

    @Autowired
    private NguoiLienHeKhanCapRepository nguoiLienHeKhanCapRepository;

    @Autowired
    private SinhVienDangKiRepository sinhVienDangKiRepository;

    @Override
    public NguoiLienHeKhanCap findByStudentID(Long id) {

        SinhVienDangKi s = sinhVienDangKiRepository.findByID(id);

        return nguoiLienHeKhanCapRepository.findByStudent(s);
    }

    @Override
    public List<NguoiLienHeKhanCap> findAll() {

        return nguoiLienHeKhanCapRepository.findAll();
    }

    @Override
    public NguoiLienHeKhanCap findByID(Long id) {

        return nguoiLienHeKhanCapRepository.findByID(id);
    }
}
