package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "quyen", uniqueConstraints = {@UniqueConstraint(name = "quyen_UK", columnNames = "tenquyen")})
public class Quyen extends BaseSmall {

    @Column(name = "tenquyen", nullable = false)
    private String tenQuyen;

    @Column(name = "mota")
    private String moTa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nhomquyen", nullable = false)
    private NhomQuyen nhomQuyen;

    @ManyToMany(mappedBy = "quyenSet", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<TaiKhoan> taiKhoanSet;

    public NhomQuyen getNhomQuyen() {
        return nhomQuyen;
    }

    public Set<TaiKhoan> getTaiKhoanSet() {
        return taiKhoanSet;
    }

    public void setNhomQuyen(NhomQuyen nhomQuyen) {
        this.nhomQuyen = nhomQuyen;
    }

    public Quyen() {
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }


}
