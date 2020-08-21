package vn.tuyensinh.hoctiengviet.dto.apiParam;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonPropertyOrder({"tenQuyen","nhomQuyen","nguoiTao"})
public class GetRoleParam {

    private String tenQuyen;

    private String nhomQuyen;

    private String nguoiTao;

}
