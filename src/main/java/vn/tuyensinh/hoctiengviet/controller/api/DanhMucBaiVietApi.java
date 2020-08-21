package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.model.request.CategoryNewsRequest;
import vn.tuyensinh.hoctiengviet.model.request.DeleteReQuestInteger;
import vn.tuyensinh.hoctiengviet.services.impl.DanhMucBaiVietServiceImpl;
import vn.tuyensinh.hoctiengviet.util.Constant;

@RestController
@RequestMapping("/v1/api/admin/categories")
public class DanhMucBaiVietApi {

    @Autowired
    private DanhMucBaiVietServiceImpl danhMucBaiVietService;


    @PostMapping
    public ResponseEntity<ResponseDTO> insertCategory(@RequestBody CategoryNewsRequest c){

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(danhMucBaiVietService.insert(c))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateCategory(@RequestBody CategoryNewsRequest c){


        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                .map(danhMucBaiVietService.update(c))
                .code(Constant.RESPONSE.CODE.C200)
                .message(Constant.RESPONSE.MESSAGE.C200)
                .build()
        );
    }


    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteCategories(@RequestBody DeleteReQuestInteger rq) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(danhMucBaiVietService.deleteMany(rq.getIds()))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }

}
