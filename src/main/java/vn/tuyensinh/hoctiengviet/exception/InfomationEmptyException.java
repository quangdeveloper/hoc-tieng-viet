package vn.tuyensinh.hoctiengviet.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfomationEmptyException extends RuntimeException {

    final static String MESSAGE= "Thông tin đầu vào không đầy đủ";

    private String message = MESSAGE;

}
