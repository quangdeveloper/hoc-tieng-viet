package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.tuyensinh.hoctiengviet.constant.ConstantRole;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;
import vn.tuyensinh.hoctiengviet.model.request.GiangVienRequest;
import vn.tuyensinh.hoctiengviet.model.response.GiangVienResponse;
import vn.tuyensinh.hoctiengviet.services.impl.GiangVienServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.GioiTinhServiceImpl;
import vn.tuyensinh.hoctiengviet.util.Constant;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/api/admin/lectures")
public class GiangVienApi {


    @Autowired
    private GiangVienServiceImpl giangVienService;

    @Autowired
    private GioiTinhServiceImpl gioiTinhService;


    //    them moi 1 giang vien
    @PostMapping
    public ResponseEntity<ResponseDTO> addLecture(@RequestBody GiangVienRequest gv) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(giangVienService.insert(gv))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );

    }

    //  sua thong tin giang vien
    @PutMapping
    public ResponseEntity<ResponseDTO> updateLecture(@RequestBody GiangVienRequest gv) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(giangVienService.update(gv))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }

    //    xoa ds giang vien
    @DeleteMapping
    public ResponseEntity<ResponseDTO> removeLecture(@RequestBody DeleteRequest rq) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(giangVienService.deleteMany(rq.getIds()))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }





}




