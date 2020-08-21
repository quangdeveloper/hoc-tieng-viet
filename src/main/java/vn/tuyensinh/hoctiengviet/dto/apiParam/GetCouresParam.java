package vn.tuyensinh.hoctiengviet.dto.apiParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCouresParam extends PageParam {

    private String code;

    private String name;

    private LocalDate startAt;

    private LocalDate endAt;

    private int status;
}
