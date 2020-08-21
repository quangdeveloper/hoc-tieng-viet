package vn.tuyensinh.hoctiengviet.mapper;

import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.sql.Timestamp;
import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface DateMapper {

    @Named("toLoCalDateFromTimeStamp")
    default LocalDate toLocalDateFromTimeStamp(Timestamp ts){

        return ts.toLocalDateTime().toLocalDate();
    }



}
