package vn.tuyensinh.hoctiengviet.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.entity.*;
import vn.tuyensinh.hoctiengviet.model.request.SinhVienRegister;

import java.sql.Timestamp;
import java.util.List;

public interface SinhVienDangKiService {

    List<SinhVienDangKi> findAll(Integer pageNo,Integer pageSize);

    SinhVienDangKi findByID(Long id);

    SinhVienDangKi findByPassport(String passport);

    ActionDTO insert(SinhVienRegister sinhVienRegister);

    ActionDTO delete(Long id);

    ActionDTO deleteMany(Long[] ids);

    List<SinhVienDangKi> findByCondition(String hoVaTen,
                                         Integer gioiTinh,
                                         String quocGia,
                                         Integer doiTuongUuTien,
                                         Integer kieuHocBong,
                                         Integer heDaoTao,
                                         String noiHoc,
                                         Integer pageNo,
                                         Integer pageSize);
    byte[] exportExcel();

}
