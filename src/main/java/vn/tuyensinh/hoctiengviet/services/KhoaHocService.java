package vn.tuyensinh.hoctiengviet.services;

import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.CourseWebDTO;
import vn.tuyensinh.hoctiengviet.dto.StudentDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetListCourseOnWebParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.KhoaHoc;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;
import vn.tuyensinh.hoctiengviet.model.request.KhoaHocRequest;
import vn.tuyensinh.hoctiengviet.model.response.KhoaHocRespone;
import vn.tuyensinh.hoctiengviet.model.response.KhoaHocResponeRegister;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface KhoaHocService {

    List<KhoaHoc> findAll(PageParam p);

    List<CourseWebDTO> findAllEnable(PageParam p);

    List<CourseWebDTO> getListCourse(GetListCourseOnWebParam p);

    List<KhoaHocResponeRegister> getAllTrangThaiEnable();

    KhoaHocRespone findByID(Long id);

    KhoaHoc findByCourseID(String courseid);

    List<KhoaHoc> findByCondition(String maKhoaHoc,String tenKhoaHoc,String fromDate,
                                  String toDate,Integer status,Integer pageNo,Integer pageSize);

    ActionDTO insert(KhoaHocRequest khoaHocRequest);

    ActionDTO update(KhoaHocRequest khoaHoc);

    ActionDTO delete(Long id);
    
    void deleteCutom(Long[] ids);

    Boolean checkCodeExists(String code);

    byte[] exportExcel();

    List<StudentDTO> getListStudentEnroll(Long id);

}
