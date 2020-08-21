package vn.tuyensinh.hoctiengviet.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KhoaHocResponeRegister {

    private Long id;
    private String tenKhoaHoc;
    private Integer trangThai;

}
