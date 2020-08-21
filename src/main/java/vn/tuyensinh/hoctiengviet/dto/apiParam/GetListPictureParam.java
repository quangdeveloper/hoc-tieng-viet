package vn.tuyensinh.hoctiengviet.dto.apiParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListPictureParam extends PageParam{

    private Integer status;

}
