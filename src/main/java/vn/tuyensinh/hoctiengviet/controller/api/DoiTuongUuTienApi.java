package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.tuyensinh.hoctiengviet.constant.ConstantRole;
import vn.tuyensinh.hoctiengviet.entity.DoiTuongUuTien;
import vn.tuyensinh.hoctiengviet.model.request.DoiTuongUuTienRequest;
import vn.tuyensinh.hoctiengviet.services.impl.DoiTuongUuTienServiceImpl;

import java.util.List;

@RestController
public class DoiTuongUuTienApi {
    @Autowired
    private DoiTuongUuTienServiceImpl doiTuongUuTienService;

    @GetMapping("/v1/api/admin/priorities")
    public ResponseEntity<List<DoiTuongUuTien>> findAll() {
        List<DoiTuongUuTien> list = doiTuongUuTienService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/v1/api/admin/priorities")
    public ResponseEntity<Void> insertDoiTuongUuTien(@RequestBody DoiTuongUuTienRequest obj) {
        if (doiTuongUuTienService.findByTypePriorities(obj.getLoaiUuTien()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        doiTuongUuTienService.insert(obj);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/v1/api/admin/priorities")
    public ResponseEntity<DoiTuongUuTien> updatePriorities(@RequestBody DoiTuongUuTienRequest obj) {
        if (doiTuongUuTienService.findByID(obj.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/v1/api/admin/priorities/{id}")
    public ResponseEntity<Void> deletePriorities(@PathVariable("id") Integer id) {
        if (doiTuongUuTienService.findByID(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            doiTuongUuTienService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
}
