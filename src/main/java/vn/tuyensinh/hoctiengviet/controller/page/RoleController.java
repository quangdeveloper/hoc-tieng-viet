package vn.tuyensinh.hoctiengviet.controller.page;


import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetRoleParam;
import vn.tuyensinh.hoctiengviet.entity.NhomQuyen;
import vn.tuyensinh.hoctiengviet.entity.Quyen;
import vn.tuyensinh.hoctiengviet.services.impl.*;

import java.util.List;

@Controller
@RequestMapping("/v1/admin/roles")
public class RoleController {


    @Autowired
    private QuyenServiceImpl quyenService;


    @Autowired
    public DoiTuongUuTienServiceImpl doiTuongUuTienService;


    @Autowired
    private NhomQuyenServiceImpl nhomQuyenService;


    //   lay trang quan li role
    @GetMapping
    public ModelAndView rolePage() {

        List<Quyen> list = quyenService.findAll();

        List<NhomQuyen> groups= nhomQuyenService.findAll();

        ModelAndView mav = new ModelAndView("admin/role/list");

        mav.addObject("groups",groups);

        mav.addObject("list", list);

        return mav;
    }

    @GetMapping("/searchs")
    public ModelAndView searchRolePage(@ApiParam GetRoleParam roleParam) {

        List<Quyen> list = quyenService.searchCondiTion(roleParam);

        List<NhomQuyen> groups= nhomQuyenService.findAll();

        ModelAndView mav = new ModelAndView("admin/role/search");

        mav.addObject("list", list);

        mav.addObject("groups",groups);

        return mav;
    }

    //    lay trang them or sua role
    @GetMapping("/add")
    public ModelAndView roleEditPage(@RequestParam("id") Integer id) {

        ModelAndView mav = new ModelAndView("admin/role/edit");

        mav.addObject("nhomQuyenList", nhomQuyenService.findAll());

        if (id == null ) {

            return mav;

        } else {

            mav.addObject("obj", quyenService.findByID(id));

            return mav;
        }
    }

    @GetMapping("/users")
    public ModelAndView listStudentOfCourse(@RequestParam("id")Integer id) {

        ModelAndView mav = new ModelAndView("admin/role/listUser");

        mav.addObject("list",quyenService.getListUserOfRole(id));

        return mav;
    }

}
