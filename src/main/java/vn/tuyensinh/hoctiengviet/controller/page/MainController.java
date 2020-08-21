package vn.tuyensinh.hoctiengviet.controller.page;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.PagingSearchCoures;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetRoleParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.*;
import vn.tuyensinh.hoctiengviet.services.impl.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private GioiTinhServiceImpl gioiTinhService;


    @Autowired
    public DoiTuongUuTienServiceImpl doiTuongUuTienService;

    @Autowired
    private CoSoDaoTaoServicesImpl coSoDaoTaoServices;

    @Autowired
    private HeDaoTaoServicesImpl heDaoTaoServices;

    @Autowired
    private LoaiHocBongServiceImpl hocBongService;

    @Autowired
    private TrinhDoNgoaiNguServicesImpl trinhDoNgoaiNguServices;


    @Autowired
    private KhoaHocServiceImpl khoaHocService;

    @Autowired
    private BaiVietServiceImpl baiVietService;

    /**    lay trang login */
    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    /**   lay trang chu admin */
    @GetMapping("/v1/admin/home")
    public ModelAndView adminHomePage() {
        return new ModelAndView("admin/home");
    }

// controller web page //

    // lay trang chu web
    @GetMapping("/v1/web")
    public ModelAndView getWebHomePage() {

        ModelAndView mav = new ModelAndView("web/home");

        PageParam p = new PageParam();
        p.setPageNo(1);
        p.setPageSize(10);
        mav.addObject("news",baiVietService.findAll(p));
        return mav;
    }

       @GetMapping("/403")
    public ModelAndView get403Page() {
        return new ModelAndView("error/403");
    }

    @GetMapping("/v1/web/registers")
    public ModelAndView getRegisterPage(){

        ModelAndView mav= new ModelAndView("/web/register");

        mav.addObject("genders", gioiTinhService.findAll());

        mav.addObject("priorities", doiTuongUuTienService.findAll());

        mav.addObject("scholarships", hocBongService.findAll());

        mav.addObject("trainningTypes", heDaoTaoServices.findAll());

        mav.addObject("shools",coSoDaoTaoServices.findAll());

        mav.addObject("courses",khoaHocService.getAllTrangThaiEnable());

        mav.addObject("branchs",coSoDaoTaoServices.getAll());

        mav.addObject("languageLevels",trinhDoNgoaiNguServices.findAll());

        return mav;
    }

    @GetMapping("/v1/web/news/{id}")
    public ModelAndView getNewsDetailPage(@PathVariable Long id){

        ModelAndView mav = new ModelAndView("/web/newDetail");
        BaiViet news = baiVietService.findByID(id);
        mav.addObject("obj",news);

        return mav;
    }







}
