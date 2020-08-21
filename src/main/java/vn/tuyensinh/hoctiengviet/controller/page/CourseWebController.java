package vn.tuyensinh.hoctiengviet.controller.page;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.dto.CourseWebDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetListCourseOnWebParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.KhoaHoc;
import vn.tuyensinh.hoctiengviet.services.impl.KhoaHocServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/v1/web/courses")
public class CourseWebController {

    @Autowired
    private KhoaHocServiceImpl khoaHocService;

    @GetMapping
    public ModelAndView coursePage(@ApiParam PageParam p) {

        ModelAndView mav = new ModelAndView("/web/listCourse");


        List<CourseWebDTO> list = khoaHocService.findAllEnable(p);

        mav.addObject("list", list);

        Paging paging = Paging.builder()
                .pageNo(p.getPageNo())
                .totalPage(list.size() / p.getPageSize() + 5)
                .build();

        mav.addObject("pagination", paging);

        return mav;
    }

    @GetMapping("/search")
    public ModelAndView courseSearchPage(@ApiParam GetListCourseOnWebParam p) {

        ModelAndView mav = new ModelAndView("/web/searchCourse");

        List<CourseWebDTO> list = khoaHocService.getListCourse(p);

        mav.addObject("list", list);

        Paging paging = Paging.builder()
                .pageNo(p.getPageNo())
                .totalPage(list.size() / p.getPageSize() + 5)
                .build();

        mav.addObject("pagination", paging);

        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView coursePage(@PathVariable Long id) {

        ModelAndView mav = new ModelAndView("/web/courseDetail");
        mav.addObject("obj", khoaHocService.findByID(id));
        return mav;
    }
}
