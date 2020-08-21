package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nhomquyen", uniqueConstraints = {@UniqueConstraint(columnNames = "manhom")})
public class NhomQuyen extends  BaseSmall {
    @Column(name = "tennhom", nullable =  false)
    private String tenNhom;

    @Column(name = "manhom", nullable = false)
    private String maNhom;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "nhomQuyen",cascade = CascadeType.ALL)
    private Set<Quyen> quyenSet;

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }
}
