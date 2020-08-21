package vn.tuyensinh.hoctiengviet.dto.apiParam;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import vn.tuyensinh.hoctiengviet.util.Constant.Common;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PageParam {

    @NotNull
    @Min(value = 1)
    private Integer pageNo = Common.PAGE_SIZE;

    @NotNull
    @Min(1)
    private Integer pageSize = Common.PAGE_NUM;

}
