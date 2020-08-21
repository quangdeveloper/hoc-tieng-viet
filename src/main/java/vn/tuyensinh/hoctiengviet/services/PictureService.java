package vn.tuyensinh.hoctiengviet.services;

import org.springframework.web.multipart.MultipartFile;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.PageDTO;
import vn.tuyensinh.hoctiengviet.dto.PictureNewDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetListPictureParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.Picture;
import vn.tuyensinh.hoctiengviet.model.request.NewRequest;

import java.util.List;

public interface PictureService {

    PageDTO findAll(PageParam p);

    PageDTO findByStatus(GetListPictureParam p);

    String upload(MultipartFile[] m);

    ActionDTO addPicture(PictureNewDTO p);

    ActionDTO deletePicture(Long id);
}
