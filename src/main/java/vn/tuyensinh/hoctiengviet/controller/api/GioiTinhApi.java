package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;
import vn.tuyensinh.hoctiengviet.entity.ThanhTichHocTap;
import vn.tuyensinh.hoctiengviet.services.impl.GioiTinhServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.ThanhTichHocTapServiceImpl;

import java.util.List;

@RestController
public class GioiTinhApi {
    @Autowired
    private GioiTinhServiceImpl gioiTinhService;

    @GetMapping("/v1/api/admin/genders")
    public ResponseEntity<List<GioiTinh>> findAll() {
        List<GioiTinh> list = gioiTinhService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("/v1/api/admin/genders/{id}")
    public ResponseEntity<GioiTinh> findByID(@PathVariable("id")Integer id) {
        GioiTinh obj= gioiTinhService.findByID(id);
        if (obj==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(obj);
    }
}
