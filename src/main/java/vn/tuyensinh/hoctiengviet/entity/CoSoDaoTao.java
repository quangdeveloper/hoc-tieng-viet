package vn.tuyensinh.hoctiengviet.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name="cosodaotao")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class CoSoDaoTao extends BaseEntity{

    @NotNull
    private String tenCoSo;

    @NotNull
    private String diaDiem;

    @NotNull
    @CreatedDate
    @Column(updatable = false)
    private Timestamp ngayThanhLap;



}
