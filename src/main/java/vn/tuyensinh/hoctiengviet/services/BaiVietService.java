package vn.tuyensinh.hoctiengviet.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.NewsParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.BaiViet;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;
import vn.tuyensinh.hoctiengviet.model.request.NewRequest;

import java.util.List;

public interface BaiVietService {

    List<BaiViet> findAll(PageParam p);

    List<BaiViet> searchCondition(NewsParam p);

    ActionDTO insert(NewRequest n);

    ActionDTO update(NewRequest n);

    ActionDTO delete(DeleteRequest rq);

    BaiViet findByID(Long id);

}
