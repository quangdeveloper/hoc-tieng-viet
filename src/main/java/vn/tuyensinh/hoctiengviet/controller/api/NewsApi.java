package vn.tuyensinh.hoctiengviet.controller.api;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.NewsParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;
import vn.tuyensinh.hoctiengviet.model.request.NewRequest;
import vn.tuyensinh.hoctiengviet.services.impl.BaiVietServiceImpl;
import vn.tuyensinh.hoctiengviet.util.Constant;

@RestController
@RequestMapping("/v1/api/admin/news")
public class NewsApi {

    @Autowired
    private BaiVietServiceImpl baiVietService;

    @GetMapping
    public ResponseEntity<Object> getAll(@ApiParam PageParam p) {

        return ResponseEntity.ok(baiVietService.findAll(p));
    }


    @DeleteMapping
    public ResponseEntity<ResponseDTO> delete(@RequestBody DeleteRequest rq) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .map(baiVietService.delete(rq))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> insert(@RequestBody NewRequest r) {

        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                .map(baiVietService.insert(r))
                .code(Constant.RESPONSE.CODE.C200)
                .message(Constant.RESPONSE.MESSAGE.C200)
                .build()
        );
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody NewRequest r) {
        
        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .map(baiVietService.update(r))
                        .code(Constant.RESPONSE.CODE.C200)
                        .message(Constant.RESPONSE.MESSAGE.C200)
                        .build()
        );
    }

}
