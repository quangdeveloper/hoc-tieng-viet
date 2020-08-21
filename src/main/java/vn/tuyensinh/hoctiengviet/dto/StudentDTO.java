package vn.tuyensinh.hoctiengviet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private long id;

    private String fullName;

    private String  gender;

    private LocalDate dateOfBirth;

    private String national;

    private String placeLearn;

    private String priority;

    private String scholarship;

}
