package vn.tuyensinh.hoctiengviet.mapper;


import org.mapstruct.Mapper;
import vn.tuyensinh.hoctiengviet.dto.PictureDTO;
import vn.tuyensinh.hoctiengviet.dto.PictureNewDTO;
import vn.tuyensinh.hoctiengviet.entity.Picture;

@Mapper(componentModel = "spring")
public interface PictureMapper {

    PictureDTO toPictureDTOFromPicture(Picture p);

}
