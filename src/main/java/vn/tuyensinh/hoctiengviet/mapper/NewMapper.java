package vn.tuyensinh.hoctiengviet.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.tuyensinh.hoctiengviet.entity.BaiViet;
import vn.tuyensinh.hoctiengviet.model.request.NewRequest;

@Mapper(componentModel = "spring")
public interface NewMapper {

    @Mappings({
            @Mapping(source = "trangThai", target = "trangThai",ignore = true)
    })
    BaiViet toNewFromNewRequest(NewRequest o);
}
