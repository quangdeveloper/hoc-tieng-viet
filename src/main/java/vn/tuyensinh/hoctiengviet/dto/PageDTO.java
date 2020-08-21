package vn.tuyensinh.hoctiengviet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@Builder
public class PageDTO {


    @Builder.Default
    private Object content = Collections.emptyList();

    private long total = 0;

}
