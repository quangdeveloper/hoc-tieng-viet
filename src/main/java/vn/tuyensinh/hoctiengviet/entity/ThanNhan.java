package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "thannhan")
public class ThanNhan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long ID;

    @Column(name = "hovaten")
    private String hoVaTen;

    @Column(name = "quanhe")
    private String quanHe;

    @Column(name = "tuoi")
    private Integer tuoi;

    @Column(name = "nghenghiep")
    private String ngheNghiep;

    @Column(name = "diachi")
    private String diaChi;

    @ManyToMany(mappedBy = "thanNhanList",fetch = FetchType.LAZY)
    private Set<SinhVienDangKi> sinhVienDangKiList;

    public ThanNhan() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getQuanHe() {
        return quanHe;
    }

    public void setQuanHe(String quanHe) {
        this.quanHe = quanHe;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Set<SinhVienDangKi> getSinhVienDangKiList() {
        return sinhVienDangKiList;
    }

    public void setSinhVienDangKiList(Set<SinhVienDangKi> sinhVienDangKiList) {
        this.sinhVienDangKiList = sinhVienDangKiList;
    }
}
