package vn.tuyensinh.hoctiengviet.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.PagingSearchCoures;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.services.impl.*;

import java.util.List;

@Controller
public class AccountControlller {

    @Autowired
    private TaiKhoanServiceImpl taiKhoanService;
    
    @Autowired
    private GioiTinhServiceImpl gioiTinhService;

    @Autowired
    private QuyenServiceImpl quyenService;

    @Autowired
    private TrangThaiServiceImpl trangThaiService;
    
    @Autowired
    public DoiTuongUuTienServiceImpl doiTuongUuTienService;
    
    /**    lay trang quan li nguoi dung */
    @GetMapping("/v1/admin/accounts")
    public ModelAndView accountPage(@RequestParam("pageNo") int pageNo,
                                    @RequestParam("pageSize") int pageSize) {

        ModelAndView mav = new ModelAndView("admin/account/list");

        List<TaiKhoan> list = taiKhoanService.findAll(pageNo - 1, pageSize);
        mav.addObject("list", list);

        mav.addObject("status", trangThaiService.findAll());

        mav.addObject("genders", gioiTinhService.findAll());

        Paging paging = new Paging();
        paging.setPageNo(pageNo);
        paging.setTotalPage(list.size() / pageSize + 5);

        mav.addObject("pagination", paging);
        return mav;

    }


    /** tai khoan search condition*/

    @GetMapping("/v1/admin/accounts/search")
    public ModelAndView searchAccountCondition(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("hoVaTen") String hoVaTen,
            @RequestParam("taiKhoan") String taiKhoan,
            @RequestParam("soDienThoai") String soDienThoai,
            @RequestParam("email") String email,
            @RequestParam("nguoiTao") String nguoiTao,
            @RequestParam("ngayBatDau") String ngayBatDau,
            @RequestParam("ngayKetThuc") String ngayKetThuc,
            @RequestParam("gioiTinh") Integer gioiTinh,
            @RequestParam("trangThai") Integer trangThai   ) {

        ModelAndView mav = new ModelAndView("admin/account/search");

        mav.addObject("status", trangThaiService.findAll());

        mav.addObject("genders", gioiTinhService.findAll());

        List<TaiKhoan> list = taiKhoanService.searchCondition(hoVaTen, taiKhoan,
                soDienThoai, email, nguoiTao, ngayBatDau, ngayKetThuc, gioiTinh,
                trangThai, pageNo - 1, pageSize);
        mav.addObject("list", list);

        PagingSearchCoures paging = new PagingSearchCoures();
        paging.setPageNo(pageNo);
        paging.setTotalPage(list.size() / pageSize + 5);

        mav.addObject("pagination", paging);
        return mav;
    }


    /**    lay trang them or sua nguoi dung*/
    @GetMapping("/v1/admin/accounts/add")
    public ModelAndView accountEditPage(@RequestParam("id") Long id) {

        ModelAndView mav = new ModelAndView("admin/account/edit");

        mav.addObject("genders", gioiTinhService.findAll());

        mav.addObject("roles", quyenService.findAll());

        mav.addObject("status", trangThaiService.findAll());

        if (id == null) {

            return mav;
        } else {

            mav.addObject("tk_roles", taiKhoanService.getRoleIds(id));

            mav.addObject("obj", taiKhoanService.findByID(id));

            return mav;
        }
    }

}
