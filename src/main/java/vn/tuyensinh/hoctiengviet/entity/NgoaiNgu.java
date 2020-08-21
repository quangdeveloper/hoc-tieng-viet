package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;

@Entity
@Table(name = "ngoaingu")
public class NgoaiNgu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long ID;

    @Column(name = "tenngoaingu")
    private String tenNgoaiNgu;

    @Column(name = "trinhdonghe")
    private Integer trinhDoNghe;

    @Column(name = "trinhdonoi")
    private Integer trinhDoNoi;

    @Column(name = "trinhdodoc")
    private Integer trinhDoDoc;

    @Column(name = "trinhdoviet")
    private Integer trinhDoViet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinhviendangki", nullable = false)
    private SinhVienDangKi sinhVienDangKi;

    public NgoaiNgu() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getTrinhDoNghe() {
        return trinhDoNghe;
    }

    public void setTrinhDoNghe(Integer trinhDoNghe) {
        this.trinhDoNghe = trinhDoNghe;
    }

    public String getTenNgoaiNgu() {
        return tenNgoaiNgu;
    }

    public void setTenNgoaiNgu(String tenNgoaiNgu) {
        this.tenNgoaiNgu = tenNgoaiNgu;
    }

    public Integer getTrinhDoNoi() {
        return trinhDoNoi;
    }

    public void setTrinhDoNoi(Integer trinhDoNoi) {
        this.trinhDoNoi = trinhDoNoi;
    }

    public Integer getTrinhDoDoc() {
        return trinhDoDoc;
    }

    public void setTrinhDoDoc(Integer trinhDoDoc) {
        this.trinhDoDoc = trinhDoDoc;
    }

    public Integer getTrinhDoViet() {
        return trinhDoViet;
    }

    public void setTrinhDoViet(Integer trinhDoViet) {
        this.trinhDoViet = trinhDoViet;
    }

    public void setSinhVienDangKi(SinhVienDangKi sinhVienDangKi) {
        this.sinhVienDangKi = sinhVienDangKi;
    }
}
