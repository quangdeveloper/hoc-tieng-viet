package vn.tuyensinh.hoctiengviet.dto.apiParam;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class NewsParam extends PageParam {

    private String tieuDe;

    private String tacGia;

    private String ngayTaoBD;

    private String ngayTaoKT;

    private Integer trangThai;

    private Integer danhMuc;

    private String nguoiTao;



}
