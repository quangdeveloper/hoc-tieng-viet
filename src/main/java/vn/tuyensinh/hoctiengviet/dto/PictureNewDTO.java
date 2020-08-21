package vn.tuyensinh.hoctiengviet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PictureNewDTO {

    private String description;

    private MultipartFile[] multipartFile;


}
