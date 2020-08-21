package vn.tuyensinh.hoctiengviet.entity;

import org.hibernate.validator.constraints.EAN;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "gioitinh",uniqueConstraints = {@UniqueConstraint(name = "gioitinh_FK1",columnNames = "gioitinh")})
public class GioiTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "gioitinh",nullable = false)
    private String gioiTinh;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "gioiTinh")
    private Set<SinhVienDangKi> sinhVienDangKiList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "gioiTinh")
    private Set<GiangVien> giangVienList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "gioiTinh")
    private Set<TaiKhoan> taiKhoanList;
    public GioiTinh() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }


}
