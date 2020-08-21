package vn.tuyensinh.hoctiengviet.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hedaotao")
public class HeDaoTao extends  BaseSmall{

    @NotNull
    @Column
    private String maHeDaoTao;

    @NotNull
    @Column
    private String tenHeDaoTao;

    @Transient
    @OneToMany(mappedBy = "heDaoTao")
    private Set<SinhVienDangKi> sinhVienDangKiSet;

}
