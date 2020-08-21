package vn.tuyensinh.hoctiengviet.controller.page;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.dto.apiParam.BaseParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.NewsParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.BaiViet;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;
import vn.tuyensinh.hoctiengviet.services.impl.BaiVietServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.DanhMucBaiVietServiceImpl;
import vn.tuyensinh.hoctiengviet.services.impl.TrangThaiServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/v1/admin/news")
public class NewsController {

    @Autowired
    private BaiVietServiceImpl baiVietService;

    @Autowired
    private TrangThaiServiceImpl trangThaiService;

    @Autowired
    private DanhMucBaiVietServiceImpl danhMucBaiVietService;

    @GetMapping
    public ModelAndView getListNews(@ApiParam PageParam p){

        ModelAndView mav = new ModelAndView("/admin/new/list");

        List<BaiViet> list= baiVietService.findAll(p);

        mav.addObject("list",list);

        mav.addObject("status", trangThaiService.findAll());

        mav.addObject("types",danhMucBaiVietService.findAll());

        Paging paging = new Paging();
        paging.setPageNo(p.getPageNo());
        paging.setTotalPage(list.size() / p.getPageSize() + 5);

        mav.addObject("pagination", paging);

        return mav;
    }

    @GetMapping("/searchs")
    public ModelAndView searchCondition(@ApiParam NewsParam p){

        ModelAndView mav = new ModelAndView("/admin/new/search");

        List<BaiViet> list= baiVietService.searchCondition(p);

        mav.addObject("list",list);

        mav.addObject("status", trangThaiService.findAll());

        mav.addObject("types",danhMucBaiVietService.findAll());

        Paging paging = new Paging();

        paging.setPageNo(p.getPageNo());

        paging.setTotalPage(list.size() / p.getPageSize() + 5);

        mav.addObject("pagination", paging);

        return mav;
    }

    @GetMapping("/add")
    public ModelAndView getEditPage(@ApiParam BaseParam p){

        ModelAndView mav = new ModelAndView("/admin/new/edit");

        if(p.getId() != null){

            mav.addObject("obj",baiVietService.findByID(p.getId()));
        }

        mav.addObject("status", trangThaiService.findAll());

        mav.addObject("types",danhMucBaiVietService.findAll());

        return mav;

    }


}
