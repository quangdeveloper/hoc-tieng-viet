package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import vn.tuyensinh.hoctiengviet.entity.DoiTuongUuTien;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.entity.ThanhTichHocTap;
import vn.tuyensinh.hoctiengviet.model.request.DoiTuongUuTienRequest;
import vn.tuyensinh.hoctiengviet.services.impl.DoiTuongUuTienServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.SinhVienDangKiServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.ThanhTichHocTapServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/api/admin/academicAchievements")
public class ThanhTichHocTapApi {

    @Autowired
    private ThanhTichHocTapServiceImpl thanhTichHocTapService;


    @GetMapping
    public ResponseEntity<List<ThanhTichHocTap>> findAll() {

        List<ThanhTichHocTap> list = thanhTichHocTapService.findAll();

        if (list.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ThanhTichHocTap> findByID(@PathVariable("id")Long id) {

        ThanhTichHocTap obj= thanhTichHocTapService.findByID(id);

        if (obj==null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(obj);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<ThanhTichHocTap> findByStudentID(@PathVariable("id")Long id) {

        ThanhTichHocTap obj= thanhTichHocTapService.findByStudentID(id);
        if (obj==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ThanhTichHocTap> deleteByID(@PathVariable("id")Long id) {

        ThanhTichHocTap obj= thanhTichHocTapService.findByID(id);
        if (obj==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        thanhTichHocTapService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
