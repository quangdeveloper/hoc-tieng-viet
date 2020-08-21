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
public class CourseWebDTO {

    private long id;

    private String name;

    private String des;

    private LocalDate startAt;

    private LocalDate endAt;

    private Double fee;
}
