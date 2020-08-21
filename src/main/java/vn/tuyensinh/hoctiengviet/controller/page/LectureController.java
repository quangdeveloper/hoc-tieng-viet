package vn.tuyensinh.hoctiengviet.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.services.impl.*;

import java.util.List;

@Controller
public class LectureController {


    @Autowired
    private GioiTinhServiceImpl gioiTinhService;

    @Autowired
    private GiangVienServiceImpl giangVienService;

    @Autowired
    public DoiTuongUuTienServiceImpl doiTuongUuTienService;



    /**   lay trang quan li giang vien*/
    @GetMapping("/v1/admin/lectures")
    public ModelAndView lecturePage(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize) {

        ModelAndView mav = new ModelAndView("admin/lecture/list");

        List<GiangVien> list = giangVienService.findAll(pageNo - 1, pageSize);
        mav.addObject("list", list);

        mav.addObject("genders", gioiTinhService.findAll());

        Paging paging = new Paging();
        paging.setPageNo(pageNo);
        paging.setTotalPage(list.size() / pageSize + 5);

        mav.addObject("pagination", paging);

        mav.addObject("list", list);
        return mav;
    }

    //   lay trang searh giang vien
    @GetMapping("/v1/admin/lectures/search")
    public ModelAndView searchLecturePage(@RequestParam("pageNo") Integer pageNo,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("maGiangVien") String maGiangVien,
                                          @RequestParam("hoVaTen") String hoVaTen,
                                          @RequestParam("diaChi") String diaChi,
                                          @RequestParam("noiSinh") String noiSinh,
                                          @RequestParam("soDienThoai") String soDienThoai,
                                          @RequestParam("email") String email,
                                          @RequestParam("ngayBatDau") String ngayBatDau,
                                          @RequestParam("ngayKetThuc") String ngayKetThuc,
                                          @RequestParam("gioiTinh") Integer gioiTinh) {

        ModelAndView mav = new ModelAndView("admin/lecture/list");

        List<GiangVien> list = giangVienService.searchCondiTion(ngayBatDau, ngayKetThuc,
                hoVaTen, maGiangVien, diaChi, noiSinh, soDienThoai, email, gioiTinh, pageNo - 1, pageSize);
        mav.addObject("list", list);

        mav.addObject("genders", gioiTinhService.findAll());

        Paging paging = new Paging();
        paging.setPageNo(pageNo);
        paging.setTotalPage(list.size() / pageSize + 5);

        mav.addObject("pagination", paging);

        mav.addObject("list", list);
        return mav;
    }


    //    lay trang them or sua giang vien
    @GetMapping("/v1/admin/lectures/add")
    public ModelAndView lectureEditPage(@RequestParam("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/lecture/edit");
        mav.addObject("genders", gioiTinhService.findAll());
        if (id == null) {
            return mav;
        } else {
            mav.addObject("obj", giangVienService.findByLectureID(id));
            return mav;
        }
    }


}
