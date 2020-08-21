package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;

@Entity
@Table(name = "nguoilienhekhancap")
public class NguoiLienHeKhanCap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long ID;

    @Column(name = "ten",nullable = false)
    private String ten;

    @Column(name = "diachi",nullable = false)
    private String diaChi;

    @Column(name = "sodienthoai",nullable = false)
    private String soDienThoai;

    @Column(name = "fax",nullable = false)
    private String fax;

    @Column(name = "email",nullable = false)
    private String email;

    public SinhVienDangKi getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(SinhVienDangKi maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "masinhvien", nullable = false)
    private SinhVienDangKi maSinhVien;

    public NguoiLienHeKhanCap() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
