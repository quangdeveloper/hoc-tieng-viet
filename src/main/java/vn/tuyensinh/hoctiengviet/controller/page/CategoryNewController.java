package vn.tuyensinh.hoctiengviet.controller.page;

import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.dto.apiParam.BaseSmallParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.CategoryParam;
import vn.tuyensinh.hoctiengviet.entity.DanhMucBaiViet;
import vn.tuyensinh.hoctiengviet.services.impl.DanhMucBaiVietServiceImpl;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/v1/admin/categories")
public class CategoryNewController {

    @Autowired
    private DanhMucBaiVietServiceImpl danhMucBaiVietService;

    @GetMapping
    public ModelAndView getAllCategory(){

        ModelAndView mav= new ModelAndView("admin/categoryNew/list");

        List<DanhMucBaiViet> listCates = danhMucBaiVietService.findAll();

        mav.addObject("list",listCates);

        return mav;
    }

    @GetMapping("/searchs")
    public ModelAndView searchCategory(@ApiParam CategoryParam cate){

        ModelAndView mav= new ModelAndView("/admin/categoryNew/search");

        List<DanhMucBaiViet> listCates = danhMucBaiVietService.searchCondition(cate);

        mav.addObject("list",listCates);

        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addOrEditCategory(@ApiParam BaseSmallParam p){

        ModelAndView mav= new ModelAndView("/admin/categoryNew/edit");

        DanhMucBaiViet c = danhMucBaiVietService.findByID(p.getId());

        mav.addObject("obj",c);

        return mav;
    }
}
