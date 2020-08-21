package vn.tuyensinh.hoctiengviet.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.tuyensinh.hoctiengviet.controller.page.pagination.Paging;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.services.impl.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private NguoiLienHeKhanCapServiceImpl nguoiLienHeKhanCapService;

    @Autowired
    private ThanhTichHocTapServiceImpl thanhTichHocTapService;

    @Autowired
    private SinhVienDangKiServiceImpl sinhVienDangKiService;

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

;

    @Autowired
    private KhoaHocServiceImpl khoaHocService;


    //   lay trang quan li ho so
    @GetMapping("/v1/admin/students")
    public ModelAndView registersPage(@RequestParam("pageNo") int pageNo,
                                      @RequestParam("pageSize") int pageSize
    ) {

        ModelAndView mav = new ModelAndView("admin/student/list");

        List<SinhVienDangKi> list = sinhVienDangKiService.findAll(pageNo - 1, pageSize);
        mav.addObject("list", list);

        mav.addObject("genders", gioiTinhService.findAll());

        mav.addObject("prioritizes", doiTuongUuTienService.findAll());

        mav.addObject("scholarship", hocBongService.findAll());

        mav.addObject("trainningTypes", heDaoTaoServices.findAll());

        mav.addObject("shools", coSoDaoTaoServices.findAll());

        Paging paging = new Paging();
        paging.setPageNo(pageNo);
        paging.setTotalPage(list.size() / pageSize + 5);

        mav.addObject("pagination", paging);

        return mav;
    }

    //   lay trang search ho so
    @GetMapping("/v1/admin/students/search")
    public ModelAndView registersSearchPage(@RequestParam("pageNo") Integer pageNo,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("hoVaTen") String hoVaTen,
                                            @RequestParam("gioiTinh") Integer gioiTinh,
                                            @RequestParam("quocGia") String quocGia,
                                            @RequestParam("doiTuongUuTien") Integer doiTuongUuTien,
                                            @RequestParam("hocBong") Integer hocBong,
                                            @RequestParam("heDaoTao") Integer heDaoTao,
                                            @RequestParam("coSoDaoTao") String coSoDaoTao
    ) {
        ModelAndView mav = new ModelAndView("admin/student/search");
        List<SinhVienDangKi> list = sinhVienDangKiService.findByCondition(
                hoVaTen,
                gioiTinh,
                quocGia,
                doiTuongUuTien,
                hocBong,
                heDaoTao,
                coSoDaoTao,
                pageNo - 1,
                pageSize);
        mav.addObject("list", list);

        mav.addObject("genders", gioiTinhService.findAll());

        mav.addObject("prioritizes", doiTuongUuTienService.findAll());

        mav.addObject("scholarship", hocBongService.findAll());

        mav.addObject("trainningTypes", heDaoTaoServices.findAll());

        mav.addObject("shools", coSoDaoTaoServices.findAll());

        Paging paging = new Paging();
        paging.setPageNo(pageNo);
        paging.setTotalPage(list.size() / pageSize + 5);

        mav.addObject("pagination", paging);

        return mav;
    }

    @GetMapping("/v1/admin/students/details")
    public ModelAndView getRegisterPage(@RequestParam("id") Long id) {

        ModelAndView mav = new ModelAndView("admin/student/detail");

        mav.addObject("genders", gioiTinhService.findAll());

        mav.addObject("priorities", doiTuongUuTienService.findAll());

        mav.addObject("scholarships", hocBongService.findAll());

        mav.addObject("trainningTypes", heDaoTaoServices.findAll());

        mav.addObject("shools", coSoDaoTaoServices.findAll());

        mav.addObject("courses", khoaHocService.getAllTrangThaiEnable());

        mav.addObject("branchs", coSoDaoTaoServices.getAll());

        mav.addObject("languageLevels", trinhDoNgoaiNguServices.findAll());

        mav.addObject("obj", sinhVienDangKiService.findByID(id)
        );

        mav.addObject("obj_nguoiLienHe", nguoiLienHeKhanCapService.findByStudentID(id));

        mav.addObject("obj_thanhTich",thanhTichHocTapService.findByStudentID(id));

        return mav;

    }

}
