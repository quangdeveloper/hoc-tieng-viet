package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doituonguutien")
public class DoiTuongUuTien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer ID;

    @Column(name = "loaiuutien",nullable = false)
    private String loaiUuTien;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "doiTuongUuTien")
    private Set<SinhVienDangKi> sinhVienDangKiList;

    public DoiTuongUuTien() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLoaiUuTien() {
        return loaiUuTien;
    }

    public void setLoaiUuTien(String loaiUuTien) {
        this.loaiUuTien = loaiUuTien;
    }


}
