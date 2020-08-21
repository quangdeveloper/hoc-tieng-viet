package vn.tuyensinh.hoctiengviet.services;

import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.model.request.TaiKhoanRequest;

import java.util.List;
import java.util.Set;

public interface TaiKhoanService {

    TaiKhoan findByID(Long id);

    TaiKhoan findByTaiKhoan(String tk);

    List<TaiKhoan> findAll(Integer pageNo, Integer pageSize);

    ActionDTO insert(TaiKhoanRequest taiKhoanRequest);

    ActionDTO update(TaiKhoanRequest taiKhoanRequest);

    ActionDTO delete(Long id);

    ActionDTO deleteMany(Long[] ids);

    List<String> getRoleNames(Long id);

    Set<Integer> getRoleIds(Long id);

    List<TaiKhoan> searchCondition(String hoVaTen, String taiKhoan, String soDienThoai,
                                   String email, String nguoiTao, String ngayBatDau, String ngayKetThuc,
                                   Integer gioiTinh, Integer trangThai,Integer pageNo,Integer pageSize);
}
