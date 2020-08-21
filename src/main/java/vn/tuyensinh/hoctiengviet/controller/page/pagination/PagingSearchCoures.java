package vn.tuyensinh.hoctiengviet.controller.page.pagination;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import vn.tuyensinh.hoctiengviet.model.request.KhoaHocRequest;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagingSearchCoures{

    private int pageNo;     //trang hien tai
    private int pageSize;      //so record toi da tren 1 trang
    private int totalPage;  //tong so trang
    private int totalItem;//tong so record tra ra
    private String maKhoaHoc;
    private String tenKhoaHoc;
    private String ngayBatDau;
    private String ngayKetThuc;
    private Integer trangThai;

}
