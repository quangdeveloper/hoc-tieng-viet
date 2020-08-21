package vn.tuyensinh.hoctiengviet.services;

import vn.tuyensinh.hoctiengviet.model.request.ExcelRequest;

import java.util.List;

public interface ExcelServices {
    byte[] write(ExcelRequest excelRequest, List<Object[]> rows);
}
