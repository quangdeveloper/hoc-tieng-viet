package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;
import vn.tuyensinh.hoctiengviet.model.request.GiangVienRequest;
import vn.tuyensinh.hoctiengviet.model.request.TaiKhoanRequest;
import vn.tuyensinh.hoctiengviet.services.impl.QuyenServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.TaiKhoanServiceImpl;
import vn.tuyensinh.hoctiengviet.util.Constant;

@RestController
@RequestMapping("/v1/api/admin/accounts")
public class TaiKhoanApi {
    @Autowired
    private TaiKhoanServiceImpl taiKhoanService;


    @DeleteMapping
    public ResponseEntity<ResponseDTO> removeAccount(@RequestBody DeleteRequest rq) {

        return ResponseEntity.ok().body(ResponseDTO.builder()
                .map(taiKhoanService.deleteMany(rq.getIds()))
                .code(Constant.RESPONSE.CODE.C200)
                .message(Constant.RESPONSE.MESSAGE.C200)
                .build());
    }


    @PostMapping
    public ResponseEntity<ResponseDTO> addAccount(@RequestBody TaiKhoanRequest tk) {

            return ResponseEntity.ok().body(ResponseDTO.builder()
            .map(taiKhoanService.insert(tk))
            .code(Constant.RESPONSE.CODE.C200)
            .message(Constant.RESPONSE.MESSAGE.C200)
            .build());

    }

    //  sua thong tin giang vien
    @PutMapping
    public ResponseEntity<ResponseDTO> updateAccount(@RequestBody TaiKhoanRequest tk) {

        return ResponseEntity.ok().body(ResponseDTO.builder()
                .map( taiKhoanService.update(tk))
                .code(Constant.RESPONSE.CODE.C200)
                .message(Constant.RESPONSE.MESSAGE.C200)
                .build());

    }
}
