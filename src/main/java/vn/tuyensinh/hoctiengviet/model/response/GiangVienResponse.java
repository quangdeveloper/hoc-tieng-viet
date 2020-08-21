package vn.tuyensinh.hoctiengviet.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.tuyensinh.hoctiengviet.entity.GioiTinh;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiangVienResponse {

    private Long id;

    private String maGiangVien;

    private String hoVaTen;

    private String diaChi;

    private String noiSinh;

    private String email;

    private String soDienThoai;

    private LocalDate ngayBatDau;

    private LocalDate ngayKetThuc;

    private GioiTinh gioiTinh;

}
