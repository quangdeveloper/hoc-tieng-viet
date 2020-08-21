package vn.tuyensinh.hoctiengviet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BooleanMapper {

    @Named("booleanToInteger")
    default Integer booleanToInteger(Boolean b) {

        if (b != null && Boolean.TRUE.equals(b)) {

            return 1;
        }
        return 0;
    }
    @Named("integerToBoolean")
    default Boolean integerToBoolean(Integer i) {

        if (i != null && i == 1) {

            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
