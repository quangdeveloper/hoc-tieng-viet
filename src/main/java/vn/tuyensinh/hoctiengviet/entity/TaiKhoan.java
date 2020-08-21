package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "taikhoan", uniqueConstraints = {@UniqueConstraint(name = "taikhoan_UK",
                                                                columnNames = "taikhoan")})
public class TaiKhoan extends Base {

    @Column(name = "taikhoan", nullable = false)
    private String taiKhoan;

    @Column(name = "matkhau", nullable = false)
    private String matKhau;

    @Column(name = "hovaten")
    private String hoVaTen;

    @Column(name = "email")
    private String email;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gioitinh", nullable = false)
    private GioiTinh gioiTinh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trangthai", nullable = false)
    private TrangThai trangThai;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permissions",
            joinColumns = {@JoinColumn(name = "taikhoan_id")},
            inverseJoinColumns ={@JoinColumn(name = "quyen_id")})
    private Set<Quyen> quyenSet;

    public Set<Quyen> getQuyenSet() {
        return quyenSet;
    }

    public void setQuyenSet(Set<Quyen> quyenSet) {
        this.quyenSet = quyenSet;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public TaiKhoan() {
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }
}
