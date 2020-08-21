package vn.tuyensinh.hoctiengviet.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import vn.tuyensinh.hoctiengviet.entity.DanhMucBaiViet;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewRequest {

    private Long ID;

    private String tieuDe;

    private String noiDung;

    private String moTaNgan;

    private String tacGia;

    private String anhMoTa;

    private Integer danhMuc;

    private Integer trangThai;


}
