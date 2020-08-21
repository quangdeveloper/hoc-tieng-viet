package vn.tuyensinh.hoctiengviet.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import vn.tuyensinh.hoctiengviet.dto.ResponseDTO;
import vn.tuyensinh.hoctiengviet.exception.DataExistsException;
import vn.tuyensinh.hoctiengviet.exception.DeleteParentException;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.exception.NotFoundException;
import vn.tuyensinh.hoctiengviet.util.Constant;

@ControllerAdvice
@Slf4j
public class ProjectHandleException {

    @ExceptionHandler(value = {GeneralException.class})
    protected ResponseEntity<ResponseDTO> processGeneralException(GeneralException ex, WebRequest rq) {

        final ResponseDTO responseDTO = ResponseDTO.builder()
                .map(ex.getValue())
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        log.error("[ProjectHandlerException.GeneralException:{}]", ex.getMessage());
        return ResponseEntity.ok().body(responseDTO);
    }

    @ExceptionHandler(value = {DeleteParentException.class})
    protected ResponseEntity<ResponseDTO> processDeleteParentEx(DeleteParentException ex,
                                                                WebRequest rq) {
        final ResponseDTO responseDTO = ResponseDTO.builder()
                .code(Constant.RESPONSE.CODE.C600)
                .message(Constant.RESPONSE.MESSAGE.C600)
                .build();
        log.error("[ProjectHandlerException.DeleteParentException:{}]", ex.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ResponseDTO> processDeleteParentEx(NotFoundException ex,
                                                                WebRequest rq) {
        final ResponseDTO responseDTO = ResponseDTO.builder()
                .code(Constant.RESPONSE.CODE.C404)
                .message(Constant.RESPONSE.MESSAGE.C404)
                .build();
        log.error("[ProjectHandlerException.NotFoundException:{}]", ex.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @ExceptionHandler(value = {DataExistsException.class})
    protected ResponseEntity<ResponseDTO> processDeleteParentEx(DataExistsException ex,
                                                                WebRequest rq) {
        final ResponseDTO responseDTO = ResponseDTO.builder()
                .code(Constant.RESPONSE.CODE.C409)
                .message(Constant.RESPONSE.MESSAGE.C409)
                .build();
        log.error("[ProjectHandlerException.DataExistsException:{}]", ex.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
