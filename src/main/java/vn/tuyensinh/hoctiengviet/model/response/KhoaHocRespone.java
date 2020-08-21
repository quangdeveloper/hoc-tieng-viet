package vn.tuyensinh.hoctiengviet.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.tuyensinh.hoctiengviet.entity.TrangThai;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KhoaHocRespone {

    private Long ID;
    private String maKhoaHoc;
    private String tenKhoaHoc;
    private String moTa;
    private String noiDung;
    private Double hocPhi;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private TrangThai trangThai;
    private String nguoiSua;
    private String nguoiTao;

}
