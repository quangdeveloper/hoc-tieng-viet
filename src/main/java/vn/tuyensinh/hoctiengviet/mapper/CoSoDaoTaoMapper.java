package vn.tuyensinh.hoctiengviet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.tuyensinh.hoctiengviet.entity.CoSoDaoTao;
import vn.tuyensinh.hoctiengviet.model.response.CoSoDaoTaoResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoSoDaoTaoMapper {

    @Mappings(
            @Mapping(target = "id",source = "ID")

    )
    CoSoDaoTaoResponse toCoSoDaoTaoResponseFromCoSoDaoTao(CoSoDaoTao cs);
    List<CoSoDaoTaoResponse> toCoSoDaoTaoResponseFromCoSoDaoTaos(List<CoSoDaoTao> list);
}
