package vn.tuyensinh.hoctiengviet.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoSoDaoTaoResponse {
    private Integer id;
    private String tenCoSo;
}
