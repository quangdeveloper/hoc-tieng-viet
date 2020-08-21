package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "danhmucbaiviet", uniqueConstraints = {@UniqueConstraint(columnNames = "madanhmuc")})
public class DanhMucBaiViet extends BaseSmall {

    @Column(name = "madanhmuc")
    private String maDanhMuc;

    @Column(name = "tendanhmuc")
    private String tenDanhMuc;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "danhMucBaiViet")
    Set<BaiViet> baiViets;


    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

}
