package vn.tuyensinh.hoctiengviet.controller.page;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.dto.PageDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetListPictureParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.Picture;
import vn.tuyensinh.hoctiengviet.services.impl.PictureServiceImpl;

import java.util.List;


@Controller
@RequestMapping("/v1/admin/pictures")
public class PictureController {

    @Autowired
    private PictureServiceImpl pictureService;

    @GetMapping
    public ModelAndView GetListImage(@ApiParam PageParam p){

        ModelAndView mav = new ModelAndView("/admin/picture/list");

        PageDTO pageDTO = pictureService.findAll(p);

        List<Picture> pictures = (List) pageDTO.getContent();

        mav.addObject("pictures",pictures);

        Paging paging = new Paging();
        paging.setPageNo(p.getPageNo());
        paging.setTotalPage(pictures.size() / p.getPageSize() + 5);

        mav.addObject("pagination", paging);

        return mav;
    }

    @GetMapping("/add")
    public ModelAndView getEditPage(@ApiParam GetListPictureParam  p ){

        ModelAndView mav = new ModelAndView("/admin/picture/edit");

        return mav;
    }

    @GetMapping("/search")
    public ModelAndView getSearchPage(@ApiParam GetListPictureParam p){

        ModelAndView mav = new ModelAndView("/admin/picture/search");

        PageDTO pageDTO = pictureService.findByStatus(p);

        List<Picture> pictures = (List) pageDTO.getContent();

        mav.addObject("pictures",pictures);

        mav.addObject("infoSearch",p.getStatus());

        Paging paging = new Paging();
        paging.setPageNo(p.getPageNo());
        paging.setTotalPage(pictures.size() / p.getPageSize() + 5);

        mav.addObject("pagination", paging);

        return mav;
    }


}
