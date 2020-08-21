package vn.tuyensinh.hoctiengviet.model.request;

public class QuyenRequest {
    private Integer ID;
    private String nguoiTao;
    private String nguoiSua;
    private String moTa;
    private String tenQuyen;
    private Integer nhomQuyen;

    public QuyenRequest() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public Integer getNhomQuyen() {
        return nhomQuyen;
    }

    public void setNhomQuyen(Integer nhomQuyen) {
        this.nhomQuyen = nhomQuyen;
    }
}
