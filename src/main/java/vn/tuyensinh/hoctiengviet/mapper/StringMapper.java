package vn.tuyensinh.hoctiengviet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StringMapper {

    @Named("stringToInteger")
    default Integer stringToInteger(String str) {

        if (str != null && !str.isEmpty()) {

            return Integer.parseInt(str);
        }
        return -1;

    }

//    Long stringToLong(String str);
//
//    String intToString(Integer number);
//
//    String doubleToString(Double number);
}
