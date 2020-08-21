package vn.tuyensinh.hoctiengviet.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "giangvien", uniqueConstraints = {@UniqueConstraint(name = "giangvien_UK",
                                                columnNames = "magiangvien")})
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "magiangvien",nullable = false)
    private String maGiangVien;

    @Column(name = "hovaten")
    private String hoVaTen;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "noisinh")
    private String noiSinh;

    @Column(name = "email")
    private String email;

    @Column(name = "sodienthoai")
    private String soDienThoai;


    @Column(name = "ngaybatdau")
    private Timestamp ngayBatDau;


    @Column(name = "ngayketthuc")
    private Timestamp ngayKetThuc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gioitinh", nullable = false)
    private GioiTinh gioiTinh;

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public GiangVien() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
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

    public Timestamp getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Timestamp ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Timestamp getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
