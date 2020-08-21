package vn.tuyensinh.hoctiengviet.entity;

import lombok.Builder;
import vn.tuyensinh.hoctiengviet.util.Constant;

import javax.persistence.*;

@Entity
@Table(name = "thanhtichhoctap")

public class ThanhTichHocTap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long ID;

    @Column(name = "truongthpt", nullable = false)
    private String truongTHPT;

    @Column(name = "namtotnghiep", nullable = false)
    private Integer namTotNghiep;

    @Column(name = "xeploai", nullable = false)
    private String xepLoai;

    @Column(name = "jpa10", nullable = false)
    @Builder.Default
    private Integer JPA10  = Constant.Value.INTEGER_NULL;

    @Column(name = "jpa11", nullable = false)
    private Integer JPA11 = Constant.Value.INTEGER_NULL;

    @Column(name = "jpa12", nullable = false)
    private Integer JPA12 = Constant.Value.INTEGER_NULL;

    @Column(name = "thanhtichdacbiet")
    private String thanhTichDacBiet;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "masinhvien", nullable = false)
    private SinhVienDangKi maSinhVien;



    public String getThanhTichDacBiet() {
        return thanhTichDacBiet;
    }

    public void setThanhTichDacBiet(String thanhTichDacBiet) {
        this.thanhTichDacBiet = thanhTichDacBiet;
    }

    public SinhVienDangKi getMaSinhVien() {
        SinhVienDangKi newObj = new SinhVienDangKi();
        newObj.setID(maSinhVien.getID());
        return newObj;
    }

    public void setMaSinhVien(SinhVienDangKi maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTruongTHPT() {
        return truongTHPT;
    }

    public void setTruongTHPT(String truongTHPT) {
        this.truongTHPT = truongTHPT;
    }

    public Integer getNamTotNghiep() {
        return namTotNghiep;
    }

    public void setNamTotNghiep(Integer namTotNghiep) {
        this.namTotNghiep = namTotNghiep;
    }

    public String getXepLoai() {

        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public Integer getJPA10() {
        return JPA10;
    }

    public void setJPA10(Integer JPA10) {
        this.JPA10 = JPA10;
    }

    public Integer getJPA11() {
        return JPA11;
    }

    public void setJPA11(Integer JPA11) {
        this.JPA11 = JPA11;
    }

    public Integer getJPA12() {
        return JPA12;
    }

    public void setJPA12(Integer JPA12) {
        this.JPA12 = JPA12;
    }

    public ThanhTichHocTap() {
    }
}
