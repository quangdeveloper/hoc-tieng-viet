package vn.tuyensinh.hoctiengviet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture extends BaseLong{

    private String name;

    private String description;

    private String linkImage;

}
