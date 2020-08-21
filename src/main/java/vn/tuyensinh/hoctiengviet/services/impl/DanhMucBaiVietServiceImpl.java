package vn.tuyensinh.hoctiengviet.services.impl;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.constant.Constant;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.CategoryParam;
import vn.tuyensinh.hoctiengviet.entity.DanhMucBaiViet;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.mapper.CategoryNewMapper;
import vn.tuyensinh.hoctiengviet.model.request.CategoryNewsRequest;
import vn.tuyensinh.hoctiengviet.model.request.DeleteReQuestInteger;
import vn.tuyensinh.hoctiengviet.repository.DanhMucBaiVietRepository;
import vn.tuyensinh.hoctiengviet.services.DanhMucBaiVietService;
import vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE;


import java.sql.Timestamp;
import java.util.List;

@Service
public class DanhMucBaiVietServiceImpl implements DanhMucBaiVietService {

    @Autowired
    private DanhMucBaiVietRepository danhMucBaiVietRepository;

    @Autowired
    private CategoryNewMapper categoryNewMapper;


    @Override
    public List<DanhMucBaiViet> findAll() {

        return danhMucBaiVietRepository.findAll(Sort.by("ID").descending());
    }

    @Override
    public List<DanhMucBaiViet> searchCondition(CategoryParam c) {

        return danhMucBaiVietRepository.searchCondition(c.getMaDanhMuc(), c.getTenDanhMuc());
    }

    @Override
    public DanhMucBaiViet findByCode(String code) {

        return danhMucBaiVietRepository.finbByCode(code);
    }

    @Override
    public ActionDTO update(CategoryNewsRequest c) {

        danhMucBaiVietRepository.findById(c.getId()).orElseThrow(
                () -> new GeneralException(RESPONSE.CODE.C404,
                        RESPONSE.MESSAGE.C404_CATEGORY_NEW)
        );

        DanhMucBaiViet obj = categoryNewMapper.toDanhMucBaiVietFromCategoryNewRequest(c);

        obj.setNgayTao(danhMucBaiVietRepository.finbByID(c.getId()).getNgayTao());

        obj.setNgaySua(new Timestamp(System.currentTimeMillis()));

        obj.setNguoiTao(danhMucBaiVietRepository.finbByID(c.getId()).getNguoiTao());// chua update authentication

        obj.setNguoiSua(Constant.INFO_DEFAULT);// chua update authentication

        DanhMucBaiViet s = danhMucBaiVietRepository.save(obj);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, s.getID())
                .build());
    }


    @Override
    public ActionDTO insert(CategoryNewsRequest c) {

        if (danhMucBaiVietRepository.finbByCode(c.getMaDanhMuc()) != null) {
            throw new GeneralException(RESPONSE.CODE.C409,
                    RESPONSE.MESSAGE.C409_CATEGORY_NEW);
        }

        DanhMucBaiViet obj = categoryNewMapper.toDanhMucBaiVietFromCategoryNewRequest(c);

        obj.setNgayTao(new Timestamp(System.currentTimeMillis()));

        obj.setNgaySua(Constant.DATE_DEFAULT);

        obj.setNguoiTao(Constant.INFO_DEFAULT); //update authentication

        obj.setNguoiSua(Constant.INFO_DEFAULT); //update authentication

        obj = danhMucBaiVietRepository.save(obj);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, obj.getID())
                .build());
    }

    @Override
    public DanhMucBaiViet findByID(Integer id) {

        return danhMucBaiVietRepository.finbByID(id);
    }

    @Override
    public ActionDTO delete(Integer id) {

        danhMucBaiVietRepository.deleteById(id);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN,id)
                .build());
    }

    @Override
    public ActionDTO deleteMany(Integer[] ids) {

        for (int i : ids){
            delete(i);
        }
        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN,ids)
                .build());
    }
}
