package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.entity.Quyen;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.model.request.DeleteReQuestInteger;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;
import vn.tuyensinh.hoctiengviet.model.request.QuyenRequest;
import vn.tuyensinh.hoctiengviet.model.request.TaiKhoanRequest;
import vn.tuyensinh.hoctiengviet.services.impl.QuyenServiceImpl;
import vn.tuyensinh.hoctiengviet.util.Constant;

@RestController
@RequestMapping("/v1/api/admin/roles")
public class QuyenApi {
    @Autowired
    private QuyenServiceImpl quyenService;


    @DeleteMapping
    public ResponseEntity<ResponseDTO> removeRole(@RequestBody DeleteReQuestInteger rq) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map( quyenService.deleteMany(rq.getIds()))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }


    @PostMapping
    public ResponseEntity<ResponseDTO> addRole(@RequestBody QuyenRequest quyenRequest) {

          return ResponseEntity.ok().body(
                  ResponseDTO.builder()
                  .map( quyenService.insert(quyenRequest))
                  .code(Constant.RESPONSE.CODE.C200)
                  .message(Constant.RESPONSE.MESSAGE.C200)
                  .build()
          );

    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateRole(@RequestBody QuyenRequest quyenRequest) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(quyenService.update(quyenRequest))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );

    }
}
