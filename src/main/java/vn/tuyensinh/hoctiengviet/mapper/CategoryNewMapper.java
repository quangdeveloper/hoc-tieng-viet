package vn.tuyensinh.hoctiengviet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.tuyensinh.hoctiengviet.entity.DanhMucBaiViet;
import vn.tuyensinh.hoctiengviet.model.request.CategoryNewsRequest;

@Mapper(componentModel = "spring")
public interface CategoryNewMapper {

    @Mappings({
            @Mapping(source = "id",target = "ID")
    })
    DanhMucBaiViet toDanhMucBaiVietFromCategoryNewRequest(CategoryNewsRequest c);
}
