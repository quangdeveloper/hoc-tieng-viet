package vn.tuyensinh.hoctiengviet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;

    private String username;

    private String fullName;

    private String gender;

    private String email;

    private  String phone;

    private LocalDate createdAt;

    private String createdBy;

    private String status;


}
