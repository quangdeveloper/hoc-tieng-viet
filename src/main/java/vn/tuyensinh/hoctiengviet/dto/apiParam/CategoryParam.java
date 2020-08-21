package vn.tuyensinh.hoctiengviet.dto.apiParam;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({"maDanhMuc","tenDanhMuc"})
@Data
public class CategoryParam {

    private String tenDanhMuc;

    private String maDanhMuc;
}
