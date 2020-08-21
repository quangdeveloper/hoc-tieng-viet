package vn.tuyensinh.hoctiengviet.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.tuyensinh.hoctiengviet.entity.NgoaiNgu;
import vn.tuyensinh.hoctiengviet.entity.NguoiLienHeKhanCap;
import vn.tuyensinh.hoctiengviet.entity.ThanNhan;
import vn.tuyensinh.hoctiengviet.entity.ThanhTichHocTap;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienRegister {

    private Long id;

    private String hoVaTen;

    private String ngaySinh;

    private Integer gioiTinh;

    private String noiSinh;

    private String quocGia;

    private String soHoChieu;

    private String diaChi;

    private String soDienThoai;

    private String fax;

    private String email;

    private NguoiLienHeKhanCap nguoiLienHeKhanCap;

    private Set<ThanNhan> listThanNhan;

    private ThanhTichHocTap thanhTichHocTap;

    private Set<NgoaiNgu> ngoaiNguList;

    private Long maKhoaHoc;

    private String noiHoc;

    private Integer heDaoTao;

    private Integer nienKhoa;

    private Integer doiTuongUuTien;

    private  Integer loaiHocBong;


}
