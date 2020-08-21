package vn.tuyensinh.hoctiengviet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.tuyensinh.hoctiengviet.dto.CourseWebDTO;
import vn.tuyensinh.hoctiengviet.entity.KhoaHoc;
import vn.tuyensinh.hoctiengviet.model.response.KhoaHocRespone;
import vn.tuyensinh.hoctiengviet.model.response.KhoaHocResponeRegister;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KhoaHocMapper {
    @Mappings({
            @Mapping(source = "ID", target = "id"),
            @Mapping(source = "trangThai.ID", target = "trangThai")
    })
    KhoaHocResponeRegister toKhoaHocResponeRegisterFromKhoaHoc(KhoaHoc khoaHoc);
    List<KhoaHocResponeRegister> toKhoaHocResponeRegisterFromKhoaHocs(List<KhoaHoc> khoaHoc);

    KhoaHocRespone toKhoaHocResponseFromKhoaHoc(KhoaHoc k);

    @Mappings({
            @Mapping(target = "id",source = "ID"),
            @Mapping(target = "name",source = "tenKhoaHoc"),
            @Mapping(target = "des",source = "moTa"),
            @Mapping(target = "startAt",source = "ngayBatDau",qualifiedByName = "toLoCalDateFromTimeStamp"),
            @Mapping(target = "endAt",source = "ngayKetThuc",qualifiedByName = "toLoCalDateFromTimeStamp"),

    })
    CourseWebDTO toCourseWebDTOFromCourse(KhoaHoc k);
}
