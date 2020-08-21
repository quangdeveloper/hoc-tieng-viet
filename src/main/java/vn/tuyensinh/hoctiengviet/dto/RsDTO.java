package vn.tuyensinh.hoctiengviet.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class RsDTO<T> {

    List<T> content = Collections.emptyList();

    public RsDTO(T content){

        if (content!= null){
            this.content = Arrays.asList(content);
        }
    }

    public RsDTO(List<T> content)
    {
        if (content!= null) this.content = content;
    }
}
