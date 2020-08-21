package vn.tuyensinh.hoctiengviet.dto.apiParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCourseOnWebParam extends PageParam {

    private String name;

}
