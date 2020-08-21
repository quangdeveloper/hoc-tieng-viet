package vn.tuyensinh.hoctiengviet.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import vn.tuyensinh.hoctiengviet.util.Constant;

@Data
@NoArgsConstructor
public class NotFoundException extends RuntimeException {

    final String message = Constant.EXCEPTION_MESSAGE.C404;

    final String code = Constant.CODE.C404;
}
