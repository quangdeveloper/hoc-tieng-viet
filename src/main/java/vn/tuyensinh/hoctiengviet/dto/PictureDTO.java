package vn.tuyensinh.hoctiengviet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PictureDTO{

    private long id;

    private String name;

    private String description;

    private String  linkImage;

    private Boolean isActive;

}
