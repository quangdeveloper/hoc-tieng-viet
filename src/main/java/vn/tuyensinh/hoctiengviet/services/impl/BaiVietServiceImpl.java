package vn.tuyensinh.hoctiengviet.services.impl;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.constant.Constant;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.NewsParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.BaiViet;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.exception.NotFoundException;
import vn.tuyensinh.hoctiengviet.mapper.NewMapper;
import vn.tuyensinh.hoctiengviet.model.request.DeleteRequest;
import vn.tuyensinh.hoctiengviet.model.request.NewRequest;
import vn.tuyensinh.hoctiengviet.repository.BaiVietRepository;
import vn.tuyensinh.hoctiengviet.repository.DanhMucBaiVietRepository;
import vn.tuyensinh.hoctiengviet.repository.TrangThaiRepository;
import vn.tuyensinh.hoctiengviet.services.BaiVietService;
import vn.tuyensinh.hoctiengviet.util.DateUtil;

import java.sql.Timestamp;
import java.util.List;

import vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE;
import vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE;

@Service
public class BaiVietServiceImpl implements BaiVietService {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Autowired
    private DanhMucBaiVietRepository danhMucBaiVietRepository;

    @Autowired
    private TrangThaiRepository trangThaiRepository;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private NewMapper newMapper;

    @Autowired
    private PictureServiceImpl pictureUploadService;

    @Override
    public List<BaiViet> findAll(PageParam p) {

        Pageable pageable = PageRequest.of(

                p.getPageNo() - 1,
                p.getPageSize(),
                Sort.by("ID").descending()
        );

        return baiVietRepository.findAll(pageable).toList();
    }

    @Override
    public List<BaiViet> searchCondition(NewsParam p) {

        Pageable pageable = PageRequest.of(p.getPageNo() - 1,
                p.getPageSize(),
                Sort.by("ID").descending()
        );

        Timestamp fromDate = dateUtil.parseStringToTimeStamp(p.getNgayTaoBD());

        if (p.getNgayTaoKT() == null || p.getNgayTaoKT() == "") {

            Timestamp toDate = dateUtil.parseStringToTimeStamp(p.getNgayTaoKT());
        }
        Timestamp toDate = Constant.CURRENT_DATE_DEFAULT;

        return baiVietRepository.searchCondiTion(
                p.getTieuDe(),
                p.getTacGia(),
                danhMucBaiVietRepository.finbByID(p.getDanhMuc()),
                trangThaiRepository.findByID(p.getTrangThai()),
                fromDate,
                toDate,
                p.getNguoiTao(),
                pageable
        ).toList();
    }


    @Override
    public ActionDTO insert(NewRequest n) {

        BaiViet b = newMapper.toNewFromNewRequest(n);

        b.setNgayTao(new Timestamp(System.currentTimeMillis()));

        b.setNgaySua(Constant.DATE_DEFAULT);

        b.setNguoiTao(Constant.INFO_DEFAULT);

        b.setNguoiSua(Constant.INFO_DEFAULT);

        b.setDanhMucBaiViet(
                danhMucBaiVietRepository.
                        finbByID(n.getDanhMuc())
        );

        b.setTrangThai(
                trangThaiRepository.
                        findByID(n.getTrangThai())
        );

        b.setAnhMoTa(n.getAnhMoTa());

        b = baiVietRepository.save(b);

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, b)
                .build()
        );
    }

    @Override
    public ActionDTO update(NewRequest n) {

        BaiViet b = newMapper.toNewFromNewRequest(n);

        BaiViet old = baiVietRepository.findByID(n.getID());

        b.setNgayTao(old.getNgayTao());

        b.setNgaySua(new Timestamp(System.currentTimeMillis()));

        b.setNguoiTao(old.getNguoiTao());

        b.setNguoiSua(Constant.INFO_DEFAULT);

        b.setDanhMucBaiViet(
                danhMucBaiVietRepository.
                        finbByID(n.getDanhMuc())
        );

        b.setTrangThai(
                trangThaiRepository.
                        findByID(n.getTrangThai())
        );

        if (n.getAnhMoTa() == null) {
            b.setAnhMoTa(old.getAnhMoTa());
        } else {
            b.setAnhMoTa(n.getAnhMoTa());
        }
        /** thieu upload anh vao file he thong cua project*/
        b = baiVietRepository.save(b);

        return new ActionDTO(ImmutableMap.builder()
                .put(vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE.JSON_VALUE.VALUE_RETURN, b)
                .build()
        );

    }

    @Override
    public ActionDTO delete(DeleteRequest rq) {

        for (Long i : rq.getIds()) {
            if (baiVietRepository.findById(i) == null) throw new GeneralException(RESPONSE.CODE.C404,
                    RESPONSE.MESSAGE.C404_NEWS);

            baiVietRepository.deleteById(i);
        }

        return new ActionDTO(ImmutableMap.builder()
                .put(RESPONSE.JSON_VALUE.VALUE_RETURN, 0L)
                .build());

    }

    @Override
    public BaiViet findByID(Long id) {

        BaiViet a = baiVietRepository.findById(id).orElse(null);

        if (a == null) throw new NotFoundException();

        return a;
    }
}
