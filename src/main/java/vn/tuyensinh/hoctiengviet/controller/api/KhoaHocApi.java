package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.entity.KhoaHoc;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;
import vn.tuyensinh.hoctiengviet.model.request.KhoaHocRequest;
import vn.tuyensinh.hoctiengviet.model.response.KhoaHocRespone;
import vn.tuyensinh.hoctiengviet.services.impl.KhoaHocServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.TrangThaiServiceImpl;
import vn.tuyensinh.hoctiengviet.util.Constant;

@RestController
@RequestMapping("/v1/api/admin/courses")
public class KhoaHocApi {

    @Autowired
    KhoaHocServiceImpl khoaHocService;

    @Autowired
    private TrangThaiServiceImpl trangThaiService;



    @PostMapping
    public ResponseEntity<ResponseDTO> AddCourse(@RequestBody KhoaHocRequest khoaHoc) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(khoaHocService.insert(khoaHoc))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateCourse(@RequestBody KhoaHocRequest khoaHoc) {

        return ResponseEntity.ok().body(ResponseDTO.builder()
                .map(khoaHocService.update(khoaHoc))
                .code(Constant.RESPONSE.CODE.C200)
                .message(Constant.RESPONSE.MESSAGE.C200)
                .build()
        );

    }

    //xoa khoa hoc chua fix dc  xoa khoa hoc se xoa ca nhung sinh vieen dang ki
    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteCourse(@RequestBody DeleteRequest rq) {

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/export")
    public ResponseEntity<Object> exportCourseToExcel() {

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "Danh-sach-khoa-hoc-dang-ki.xlsx")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(khoaHocService.exportExcel())
                ;

    }


}
