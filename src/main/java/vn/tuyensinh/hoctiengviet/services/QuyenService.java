package vn.tuyensinh.hoctiengviet.services;

import org.springframework.data.repository.query.Param;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.UserDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetRoleParam;
import vn.tuyensinh.hoctiengviet.entity.Quyen;
import vn.tuyensinh.hoctiengviet.model.request.QuyenRequest;
import vn.tuyensinh.hoctiengviet.repository.QuyenRopository;

import java.util.List;

public interface QuyenService {

  List<Quyen> findAll();

  Quyen findByID(Integer id);

  String getRoleName(Quyen quyen);

  ActionDTO insert(QuyenRequest quyenRequest);

  ActionDTO delete(Integer id);

  ActionDTO deleteMany(Integer[] ids);

  ActionDTO update(QuyenRequest quyenRequest);

  Quyen findByNameRole(String name);

  List<Quyen> searchCondiTion(GetRoleParam roleParam);

  List<UserDTO> getListUserOfRole(int id);

}
