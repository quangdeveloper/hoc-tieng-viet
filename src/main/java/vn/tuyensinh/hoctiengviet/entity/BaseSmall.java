package vn.tuyensinh.hoctiengviet.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class BaseSmall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer ID;


    @Column(name = "ngaytao",nullable = false)
    private Timestamp ngayTao;

    @Column(name = "ngaysua",nullable = false)
    private Timestamp ngaySua;

    @Column(name = "nguoitao")
    private String nguoiTao;

    @Column(name = "nguoisua")
    private String nguoiSua;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Timestamp getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Timestamp ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public BaseSmall() {
    }
}
