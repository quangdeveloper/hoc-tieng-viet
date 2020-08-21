package vn.tuyensinh.hoctiengviet.services.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.model.request.ExcelRequest;
import vn.tuyensinh.hoctiengviet.services.ExcelServices;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ExcelServicesImpl implements ExcelServices {

    @Override
    public byte[] write(@NonNull ExcelRequest excelRequest, @NonNull List<Object[]> rows) {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        // Tao ten cot
        Row titleRow = sheet.createRow(0);
        for (int i = 0; i < excelRequest.getColumnsTitle().size(); i++) {

            Cell cell = titleRow.createCell(i);
            cell.setCellStyle(cellStyle(sheet, true, true, 11));
            cell.setCellValue(excelRequest.getColumnsTitle().get(i));

            sheet.setColumnWidth(i, excelRequest.getColumnsWidth().get(i) * 256);

        }
        //trim xoa khoang trống ở hai đầu chuỗi nếu có
        // them gia tri
        for (int i = 0; i < rows.size(); i++) {

            Row rowI = sheet.createRow(i + 1);//vi tri dau tien trong exel bat dau la 1
            Object[] objects = rows.get(i);

            for (int j = 0; j < objects.length; j++) {

                Cell cell = rowI.createCell(j);
                cell.setCellStyle(cellStyle(sheet, false, true, 11));
                cell.setCellValue(ObjectUtils.isEmpty(objects[j]) ? "" : String.valueOf(objects[j]).trim());
            }
        }

        // xuat ra mang byte[]
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            workbook.write(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();

        } catch (IOException ex) {
            log.error("{}", ex);

        }
        return new byte[0];
    }

    //  set up kieu cho cell
    private CellStyle cellStyle(Sheet sheet, Boolean isBold, Boolean isCentre, int fontSize) {


        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();

        Font font = sheet.getWorkbook().createFont();
        font.setBold(isBold);
        font.setFontHeightInPoints((short) fontSize);

        cellStyle.setFont(font);
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(isCentre ? HorizontalAlignment.CENTER : HorizontalAlignment.LEFT);

        return cellStyle;

    }
}
