package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;
import vn.tuyensinh.hoctiengviet.model.request.SinhVienRegister;
import vn.tuyensinh.hoctiengviet.services.impl.SinhVienDangKiServiceImpl;
import vn.tuyensinh.hoctiengviet.util.Constant;

@RestController
@RequestMapping("/v1/api/admin/students")
public class SinhVienDangKiApi {

    @Autowired
    private SinhVienDangKiServiceImpl sinhVienDangKiService;


    @PostMapping
    public ResponseEntity<ResponseDTO> insertStudent(@RequestBody SinhVienRegister sv){

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(sinhVienDangKiService.insert(sv))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }

    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteStudent(@RequestBody DeleteRequest rq) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(sinhVienDangKiService.deleteMany(rq.getIds()))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }

    @GetMapping("/exports")
    public ResponseEntity<Object> exportCourseToExcel() {

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "Danh-sach-sinh-vien-dang-ki.xlsx")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body( sinhVienDangKiService.exportExcel()
                );

    }

}
