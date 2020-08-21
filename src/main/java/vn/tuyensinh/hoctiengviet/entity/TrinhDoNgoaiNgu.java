package vn.tuyensinh.hoctiengviet.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trinhdongoaingu")
public class TrinhDoNgoaiNgu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer ID;

    @Column(name = "trinhdo", nullable = false)
    private String trinhDo;

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public TrinhDoNgoaiNgu() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }



}
