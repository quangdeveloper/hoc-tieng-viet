package vn.tuyensinh.hoctiengviet.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;
import vn.tuyensinh.hoctiengviet.model.request.GiangVienRequest;
import vn.tuyensinh.hoctiengviet.model.response.GiangVienResponse;

import java.sql.Timestamp;
import java.util.List;

public interface GiangVienService {
    List<GiangVien> findAll(Integer pageNo, Integer pageSize);

    GiangVien findByLectureCode(String code);

    GiangVienResponse findByLectureID(Long gvid);



    List<GiangVien> searchCondiTion(String ngayBatDau,
                                    String ngayKetThuc,
                                    String hoVaTen,
                                    String maGiangVien,
                                    String diaChi,
                                    String noiSinh,
                                    String soDienThoai,
                                    String email,
                                    Integer gioiTinh,
                                    Integer pageNo,
                                    Integer pageSize);

    ActionDTO insert(GiangVienRequest gv);

    ActionDTO update(GiangVienRequest gv);

    ActionDTO delete(Long id);

    ActionDTO deleteMany(Long ids[]);

    List<GiangVien> findByStartDateAndAdrress(String fromDate, String toDate, String address);
}
