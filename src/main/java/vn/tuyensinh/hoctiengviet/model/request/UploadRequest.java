package vn.tuyensinh.hoctiengviet.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadRequest {

    private MultipartFile[] multipartFile;

}
