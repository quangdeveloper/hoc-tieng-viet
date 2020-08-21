package vn.tuyensinh.hoctiengviet.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryNewsRequest {

    private Integer id;

    private String maDanhMuc;

    private String tenDanhMuc;

}
