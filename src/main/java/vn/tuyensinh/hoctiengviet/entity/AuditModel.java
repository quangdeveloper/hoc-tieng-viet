package vn.tuyensinh.hoctiengviet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@NoArgsConstructor
public class AuditModel {

    private Boolean isActive;
}
