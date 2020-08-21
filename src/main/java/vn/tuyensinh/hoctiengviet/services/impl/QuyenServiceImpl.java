package vn.tuyensinh.hoctiengviet.services.impl;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.constant.Constant;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.UserDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetRoleParam;
import vn.tuyensinh.hoctiengviet.entity.NhomQuyen;
import vn.tuyensinh.hoctiengviet.entity.Quyen;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.mapper.UserMapper;
import vn.tuyensinh.hoctiengviet.model.request.QuyenRequest;
import vn.tuyensinh.hoctiengviet.repository.NhomQuyenRepository;
import vn.tuyensinh.hoctiengviet.repository.QuyenRopository;
import vn.tuyensinh.hoctiengviet.repository.TaiKhoanRepository;
import vn.tuyensinh.hoctiengviet.services.QuyenService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE;

@Service
public class QuyenServiceImpl implements QuyenService {

    @Autowired
    private QuyenRopository quyenRopository;

    @Autowired
    private NhomQuyenRepository nhomQuyenRepository;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Quyen> searchCondiTion(GetRoleParam roleParam) {

        final NhomQuyen roleGroup;

        if (roleParam.getNhomQuyen() != null && !roleParam.getNhomQuyen().isEmpty()) {

            roleGroup = nhomQuyenRepository.findByID(Integer.parseInt(
                    roleParam.getNhomQuyen()
                    )
            );

        } else {
            roleGroup = null;
        }

        return quyenRopository.searchCondition(
                roleParam.getTenQuyen(),
                roleGroup,
                roleParam.getNguoiTao()
        );
    }

    @Override
    public List<Quyen> findAll() {

        return quyenRopository.findAll();
    }

    @Override
    public Quyen findByID(Integer id) {

        return quyenRopository.findByID(id);
    }

    @Override
    public String getRoleName(Quyen quyen) {

        return quyen.getTenQuyen();
    }

    @Override
    public List<UserDTO> getListUserOfRole(int id) {

        Quyen role = quyenRopository.findById(id).orElseThrow(
                () -> new GeneralException(RESPONSE.CODE.C404,
                        RESPONSE.MESSAGE.C404_ROLE)
        );

        List<TaiKhoan> list = new ArrayList<>();

        for (TaiKhoan i : role.getTaiKhoanSet()) {

            list.add(i);
        }
        return userMapper.toUserDTOFromUsers(list);
    }

    @Override
    public ActionDTO insert(QuyenRequest quyenRequest) {

        if (quyenRopository.findByNameRole(quyenRequest.getTenQuyen()) != null) {
            throw new GeneralException(RESPONSE.CODE.C409,
                    RESPONSE.MESSAGE.C409_ROLE);
        }

        Quyen quyen = new Quyen();

        BeanUtils.copyProperties(quyenRequest, quyen);

        quyen.setNgayTao(new Timestamp(System.currentTimeMillis()));

        quyen.setNgaySua(Constant.DATE_DEFAULT);

        quyen.setNguoiSua(Constant.INFO_DEFAULT);

        NhomQuyen nq = nhomQuyenRepository.findByID(quyenRequest.getNhomQuyen());

        if (nq == null) {

            throw new GeneralException(RESPONSE.CODE.C404,
                    RESPONSE.MESSAGE.C404_GROUP_ROLE);
        }

        quyen.setNhomQuyen(nq);

        quyen = quyenRopository.save(quyen);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, quyen.getID())
                .build()
        );
    }


    @Override
    public ActionDTO delete(Integer id) {

        Set<TaiKhoan> taiKhoans = quyenRopository
                .findByID(id)
                .getTaiKhoanSet();

        if (quyenRopository.findByID(id) == null) {

            throw new GeneralException(RESPONSE.CODE.C404, RESPONSE.MESSAGE.C404_ROLE);
        }

        if (taiKhoans == null) {

            quyenRopository.deleteById(id);
        } else {

            taiKhoans.forEach(

                    obj -> taiKhoanRepository.deleteById(obj.getID())
            );

            quyenRopository.deleteById(id);
        }

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, id)
                .build()
        );
    }

    @Override
    public ActionDTO deleteMany(Integer[] ids) {
        for (int i : ids) {

            delete(i);
        }

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, ids)
                .build()
        );
    }

    @Override
    public ActionDTO update(QuyenRequest quyenRequest) {

        Quyen old = quyenRopository.findByID(quyenRequest.getID());

        if (old == null) {
            throw new GeneralException(RESPONSE.CODE.C404,
                    RESPONSE.MESSAGE.C404_ROLE);
        }

        Quyen quyen = new Quyen();

        BeanUtils.copyProperties(quyenRequest, quyen);

        quyen.setNgayTao(old.getNgayTao());

        quyen.setNgaySua(new Timestamp(System.currentTimeMillis()));

        quyen.setNhomQuyen(nhomQuyenRepository.findByID(quyenRequest.getNhomQuyen()));

        quyen = quyenRopository.save(quyen);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, quyen.getID())
                .build()
        );
    }

    @Override
    public Quyen findByNameRole(String name) {

        return quyenRopository.findByNameRole(name);
    }


}
