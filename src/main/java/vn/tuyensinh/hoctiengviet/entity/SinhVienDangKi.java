package vn.tuyensinh.hoctiengviet.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sinhviendangki",
        uniqueConstraints = {
                @UniqueConstraint(name = "SinhVienDangKi_UK1",
                        columnNames = "sohochieu")
        })
public class SinhVienDangKi {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long ID;

    @Column(name = "hovaten", nullable = false)
    private String hoVaTen;


    @Column(name = "ngaysinh", nullable = false)
    private Timestamp ngaySinh;

    @ManyToOne
    @JoinColumn(name = "gioitinh", nullable = false)
    private GioiTinh gioiTinh;

    @Column(name = "noisinh", nullable = false)
    private String noiSinh;

    @Column(name = "quocgia", nullable = false)
    private String quocGia;

    @Column(name = "sohochieu", nullable = false)
    private String soHoChieu;

    @Column(name = "diachi", nullable = false)
    private String diaChi;

    @Column(name = "sodienthoai", nullable = false)
    private String soDienThoai;

    @Column(name = "fax", nullable = false)
    private String fax;

    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hedaotao")
    private HeDaoTao heDaoTao;


    @Column(name = "nienkhoa", nullable = false)
    private Integer nienKhoa;


    @Column(name = "noihoc", nullable = false)
    private String noiHoc;


    @ManyToOne
    @JoinColumn(name = "doituonguutien", nullable = false)
    private DoiTuongUuTien doiTuongUuTien;

    @ManyToOne
    @JoinColumn(name = "kieuhocbong", nullable = false)
    private LoaiHocBong loaiHocBong;


    @Column(name = "ngaytao", nullable = false)
    private Timestamp ngayTao;


    @OneToMany(mappedBy = "sinhVienDangKi", fetch = FetchType.LAZY)
    private Set<NgoaiNgu> ngoaiNguList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "sinhvien_thannhan",
            joinColumns = {@JoinColumn(name = "sinhvien")},
            inverseJoinColumns = {@JoinColumn(name = "thannhan")})
    private Set<ThanNhan> thanNhanList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sinhvien_khoahoc",
            joinColumns = {@JoinColumn(name = "sinhvien")},
            inverseJoinColumns = {@JoinColumn(name = "khoahoc")})
    private Set<KhoaHoc> KhoaHocList;


    public Set<NgoaiNgu> getNgoaiNguList() {
        return ngoaiNguList;
    }

    public void setNgoaiNguList(Set<NgoaiNgu> ngoaiNguList) {
        this.ngoaiNguList = ngoaiNguList;
    }


    public void setThanNhanList(Set<ThanNhan> thanNhanList) {
        this.thanNhanList = thanNhanList;
    }

    public Set<KhoaHoc> getKhoaHocList() {
        return KhoaHocList;
    }

    public void setKhoaHocList(Set<KhoaHoc> khoaHocList) {
        KhoaHocList = khoaHocList;
    }

    public SinhVienDangKi() {
    }

    public Set<ThanNhan> getThanNhanList() {
        return thanNhanList;
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

    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getSoHoChieu() {
        return soHoChieu;
    }

    public void setSoHoChieu(String soHoChieu) {
        this.soHoChieu = soHoChieu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HeDaoTao getHeDaoTao() {
        return heDaoTao;
    }

    public void setHeDaoTao(HeDaoTao heDaoTao) {
        this.heDaoTao = heDaoTao;
    }

    public Integer getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(Integer nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public String getNoiHoc() {
        return noiHoc;
    }

    public void setNoiHoc(String noiHoc) {
        this.noiHoc = noiHoc;
    }

    public DoiTuongUuTien getDoiTuongUuTien() {
        return doiTuongUuTien;
    }

    public void setDoiTuongUuTien(DoiTuongUuTien doiTuongUuTien) {
        this.doiTuongUuTien = doiTuongUuTien;
    }

    public LoaiHocBong getLoaiHocBong() {
        return loaiHocBong;
    }

    public void setLoaiHocBong(LoaiHocBong loaiHocBong) {
        this.loaiHocBong = loaiHocBong;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }


}
