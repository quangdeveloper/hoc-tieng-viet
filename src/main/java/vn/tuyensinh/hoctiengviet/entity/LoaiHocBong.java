package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "loaihocbong")
public class LoaiHocBong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer ID;

    @Column(name = "loaihocbong")
    private String loaiHocBong;

    @OneToMany(mappedBy = "loaiHocBong",fetch = FetchType.LAZY)
    private Set<SinhVienDangKi> sinhVienDangKiList;

    public LoaiHocBong() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLoaiHocBong() {
        return loaiHocBong;
    }

    public void setLoaiHocBong(String loaiHocBong) {
        this.loaiHocBong = loaiHocBong;
    }

}
