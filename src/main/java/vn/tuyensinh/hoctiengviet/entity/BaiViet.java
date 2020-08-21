package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;

@Entity
@Table(name = "baiviet")
public class BaiViet extends Base {

    @Column(name = "tieude")
    private String tieuDe;
    @Column(name = "motangan")
    private String moTaNgan;

    @Column(name = "anhmota")
    private String anhMoTa;

    @Column(name = "tacgia")
    private String tacGia;

    @Column(name = "noidung")
    private String noiDung;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "danhmucbaiviet")
    private DanhMucBaiViet danhMucBaiViet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trangthai")
    private TrangThai trangThai;

    public BaiViet() {
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTaNgan() {
        return moTaNgan;
    }

    public void setMoTaNgan(String moTaNgan) {
        this.moTaNgan = moTaNgan;
    }

    public String getAnhMoTa() {
        return anhMoTa;
    }

    public void setAnhMoTa(String anhMoTa) {
        this.anhMoTa = anhMoTa;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public DanhMucBaiViet getDanhMucBaiViet() {
        return danhMucBaiViet;
    }

    public void setDanhMucBaiViet(DanhMucBaiViet danhMucBaiViet) {
        this.danhMucBaiViet = danhMucBaiViet;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }
}
