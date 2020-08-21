package vn.tuyensinh.hoctiengviet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.tuyensinh.hoctiengviet.dto.UserDTO;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(target = "id",source = "ID"),
            @Mapping(target= "username",source = "taiKhoan"),
            @Mapping(target = "fullName",source = "hoVaTen"),
            @Mapping(target = "gender",source = "gioiTinh.gioiTinh"),
            @Mapping(target = "phone",source = "soDienThoai"),
            @Mapping(target = "status",source = "trangThai.trangThai"),
            @Mapping(target = "createdAt",source = "ngayTao",qualifiedByName = "toLoCalDateFromTimeStamp"),
            @Mapping(target = "createdBy",source = "nguoiTao")

    })
    UserDTO toUserDTOFromUser(TaiKhoan t);

    List<UserDTO> toUserDTOFromUsers(List<TaiKhoan> t);
}
