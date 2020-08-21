package vn.tuyensinh.hoctiengviet.model.request;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Builder
public class ExcelRequest {

    private String fileName;

    private String sheetName;

    @Default
    private List<String> columnsTitle = Collections.emptyList();

    @Default
    private List<Integer> columnsWidth= Collections.emptyList();
}
