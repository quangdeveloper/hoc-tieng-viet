package vn.tuyensinh.hoctiengviet.services;

import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.CategoryParam;
import vn.tuyensinh.hoctiengviet.entity.DanhMucBaiViet;
import vn.tuyensinh.hoctiengviet.model.request.CategoryNewsRequest;
import vn.tuyensinh.hoctiengviet.model.request.DeleteReQuestInteger;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;

import java.util.List;

public interface DanhMucBaiVietService {

    List<DanhMucBaiViet> findAll();

    DanhMucBaiViet findByID(Integer id);

    List<DanhMucBaiViet> searchCondition(CategoryParam c);

    ActionDTO insert(CategoryNewsRequest c);

    ActionDTO update(CategoryNewsRequest c);

    DanhMucBaiViet findByCode(String code);

    ActionDTO delete(Integer id);

    ActionDTO deleteMany(Integer[] id);




}
