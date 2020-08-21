package vn.tuyensinh.hoctiengviet.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.dto.PageDTO;
import vn.tuyensinh.hoctiengviet.dto.PictureNewDTO;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.Picture;
import vn.tuyensinh.hoctiengviet.services.impl.PictureServiceImpl;
import vn.tuyensinh.hoctiengviet.util.Constant;


import java.util.List;

@RestController
@RequestMapping("/v1/api/admin/pictures")
public class PictureAPI {


    @Autowired
    private PictureServiceImpl pictureUploadService;


    @PostMapping("/add/v1")
    public ResponseEntity<Object> uploadV1(@ModelAttribute("picture") PictureNewDTO picture){

        return ResponseEntity.ok().body(ResponseDTO.builder()
                .map(pictureUploadService.addPicture(picture))
                .code(Constant.RESPONSE.CODE.C200)
                .message(Constant.RESPONSE.MESSAGE.C200)
        );

    }

    @PostMapping("/add")
    public ModelAndView uploadV2(@ModelAttribute("picture") PictureNewDTO picture){

        pictureUploadService.addPicture(picture);

        ModelAndView mav = new ModelAndView("/admin/picture/list");

        return mav;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePicture(@PathVariable Long id){

        return ResponseEntity.ok().body(ResponseDTO.builder()
                .map(null)
                .code(Constant.RESPONSE.CODE.C200)
                .message(Constant.RESPONSE.MESSAGE.C200)
        );

    }

}
