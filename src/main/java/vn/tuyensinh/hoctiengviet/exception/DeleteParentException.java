package vn.tuyensinh.hoctiengviet.exception;

import lombok.Data;

@Data
public class DeleteParentException extends RuntimeException {

    private String message;

    private String code;

}
