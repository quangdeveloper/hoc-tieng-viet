package vn.tuyensinh.hoctiengviet.controller.page.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Paging {

    private int pageNo;     //trang hien tai
    private int pageSize;      //so record toi da tren 1 trang
    private int totalPage;  //tong so trang
    private int totalItem;//tong so record tra ra

}
