package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;
import vn.tuyensinh.hoctiengviet.model.request.TrangThaiRequest;
import vn.tuyensinh.hoctiengviet.services.impl.TrangThaiServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/api/admin/status")
public class TrangThaiApi {

    @Autowired
    private TrangThaiServiceImpl trangThaiService;

    @GetMapping
    public ResponseEntity<List<TrangThai>> getAll(){

        return ResponseEntity.ok(trangThaiService.findAll());
    }

    @PostMapping
    public ResponseEntity<TrangThai> insert(@RequestBody TrangThaiRequest trangThai){

        if (trangThaiService.findByTrangThai(trangThai.getTrangThai())!= null){

            return ResponseEntity.noContent().build();
        }else {

            TrangThai tt = new TrangThai();
            tt.setTrangThai(trangThai.getTrangThai());

            trangThaiService.insert(tt);

            return ResponseEntity.noContent().build();
        }

    }
    @PutMapping
    public ResponseEntity<TrangThai> update(@RequestBody TrangThaiRequest trangThai){

        TrangThai tt = new TrangThai();
        tt.setID(trangThai.getId());
        tt.setTrangThai(trangThai.getTrangThai());

        trangThaiService.update(tt);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id")Integer id){

        trangThaiService.remove(id);

        return ResponseEntity.noContent().build();
    }

}
