package vn.tuyensinh.hoctiengviet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import vn.tuyensinh.hoctiengviet.entity.GiangVien;
import vn.tuyensinh.hoctiengviet.model.response.GiangVienResponse;

@Mapper(componentModel = "spring")
public interface GiangVienMapper {


    GiangVienResponse toGiangVienResponseFromGiangVien(GiangVien g);
}
