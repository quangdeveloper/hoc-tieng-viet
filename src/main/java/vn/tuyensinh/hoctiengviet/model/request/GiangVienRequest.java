package vn.tuyensinh.hoctiengviet.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiangVienRequest {

    private Long id;

    private String maGiangVien;

    private String hoVaTen;

    private String diaChi;

    private String noiSinh;

    private String email;

    private String soDienThoai;

    private String ngayBatDau;

    private String ngayKetThuc;

    private Integer gioiTinh;

}
