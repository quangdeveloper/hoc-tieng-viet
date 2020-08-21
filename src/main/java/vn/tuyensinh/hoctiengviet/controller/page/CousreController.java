package vn.tuyensinh.hoctiengviet.controller.page;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.PagingSearchCoures;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetCouresParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.KhoaHoc;
import vn.tuyensinh.hoctiengviet.services.impl.*;

import java.util.List;

@Controller
@RequestMapping("/v1/admin/courses")
public class CousreController {



    @Autowired
    private TrangThaiServiceImpl trangThaiService;

    @Autowired
    private KhoaHocServiceImpl khoaHocService;


    @Autowired
    public DoiTuongUuTienServiceImpl doiTuongUuTienService;



    //   lay trang quan li course
    @GetMapping
    public ModelAndView coursePage(@ApiParam PageParam p
    ) {
        ModelAndView mav = new ModelAndView("admin/course/list");

        List<KhoaHoc> list = khoaHocService.findAll(p);

        mav.addObject("status", trangThaiService.findAll());

        mav.addObject("list", list);

        Paging paging = Paging.builder()
                .pageNo(p.getPageNo())
                .totalPage(list.size() / p.getPageSize() + 5)
                .build();

        mav.addObject("pagination", paging);

        return mav;
    }

    @GetMapping("/search")
    public ModelAndView searchCondition(@RequestParam("maKhoaHoc") String maKhoaHoc,
                                        @RequestParam("tenKhoaHoc") String tenKhoaHoc,
                                        @RequestParam("ngayBatDau") String ngayBatDau,
                                        @RequestParam("ngayKetThuc") String ngayKetThuc,
                                        @RequestParam("trangThai") Integer trangThai,
                                        @RequestParam(value = "pageNo", required = false) int pageNo,
                                        @RequestParam(value = "pageSize", required = false) int pageSize) {

        ModelAndView mav = new ModelAndView("admin/course/search");

        mav.addObject("status", trangThaiService.findAll());

        List<KhoaHoc> list = khoaHocService.
                findByCondition(maKhoaHoc, tenKhoaHoc, ngayBatDau,
                        ngayKetThuc, trangThai, pageNo - 1, pageSize);
        mav.addObject("list", list);

        PagingSearchCoures paging = new PagingSearchCoures();
        paging.setPageNo(pageNo);
        paging.setTotalPage(list.size() / pageSize + 5);

//        GetCouresParam paramSearch = GetCouresParam.builder()
//                .code(maKhoaHoc)
//                .name(tenKhoaHoc)
//                .startAt(ngayBatDau)
//                .endAt(ngayKetThuc)
//                .status(trangThai)
//                .build();
//
//        mav.addObject("paramSearch", paramSearch);

        mav.addObject("pagination", paging);

        return mav;
    }

    //    lay trang them or sua khoa hoc
    @GetMapping("/add")
    public ModelAndView courseEditPage(@RequestParam("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/course/edit");
        mav.addObject("status", trangThaiService.findAll());
        if (id == null) {
            return mav;
        } else {
            mav.addObject("obj", khoaHocService.findByID(id));
            return mav;
        }
    }

    @GetMapping("/details")
    public ModelAndView courseDetailPage(@RequestParam("id") Long id) {

        ModelAndView mav = new ModelAndView("admin/course/detail");

        mav.addObject("status", trangThaiService.findAll());

        if (id == null) {
            return mav;
        } else {
            mav.addObject("obj", khoaHocService.findByID(id));
            return mav;
        }
    }

    @GetMapping("/students")
    public ModelAndView listStudentOfCourse(@RequestParam("id") Long id) {

        ModelAndView mav = new ModelAndView("admin/course/listUser");

        mav.addObject("list", khoaHocService.getListStudentEnroll(id));

        return mav;
    }


}
