package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;
import vn.tuyensinh.hoctiengviet.entity.NgoaiNgu;
import vn.tuyensinh.hoctiengviet.services.impl.GioiTinhServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.NgoaiNguServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/api/admin/languages")
public class NgoaiNguApi {


    @Autowired
    private NgoaiNguServiceImpl ngoaiNguService;

    @GetMapping
    public ResponseEntity<List<NgoaiNgu>> findAll() {

        List<NgoaiNgu> list = ngoaiNguService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NgoaiNgu> findByID(@PathVariable("id")Long id) {

        NgoaiNgu obj= ngoaiNguService.findByID(id);
        if (obj==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(obj);
    }
}
