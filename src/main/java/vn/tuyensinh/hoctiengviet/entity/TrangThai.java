package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trangthai")
public class TrangThai {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Integer ID;

    @Column(name = "trangthai",unique = true)
    private String trangThai;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "trangThai")
    private Set<TaiKhoan> taiKhoanList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "trangThai")
    private Set<KhoaHoc> khoaHocs;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "trangThai")
    private Set<BaiViet> baiViets;

    public TrangThai() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
