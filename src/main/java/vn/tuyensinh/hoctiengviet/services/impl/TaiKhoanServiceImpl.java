package vn.tuyensinh.hoctiengviet.services.impl;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.tuyensinh.hoctiengviet.constant.Constant;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.entity.Quyen;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.model.request.TaiKhoanRequest;
import vn.tuyensinh.hoctiengviet.repository.GioiTinhRepository;
import vn.tuyensinh.hoctiengviet.repository.QuyenRopository;
import vn.tuyensinh.hoctiengviet.repository.TaiKhoanRepository;
import vn.tuyensinh.hoctiengviet.repository.TrangThaiRepository;
import vn.tuyensinh.hoctiengviet.services.TaiKhoanService;
import vn.tuyensinh.hoctiengviet.util.ParesStringToTimeStamp;
import vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE;

import java.sql.Timestamp;
import java.util.*;


@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public TaiKhoan findByID(Long id) {
        return taiKhoanRepository.findByID(id);
    }


    @Autowired
    private QuyenRopository quyenRopository;

    @Autowired
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private TrangThaiRepository trangThaiRepository;

    @Autowired
    private GioiTinhRepository gioiTinhRepository;

    @Override
    public TaiKhoan findByTaiKhoan(String tk) {
        return taiKhoanRepository.findByTaiKhoan(tk);
    }

    @Override
    public List<TaiKhoan> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("ID").descending());
        return taiKhoanRepository.findAll(pageable).toList();
    }

    @Override
    public ActionDTO insert(TaiKhoanRequest taiKhoanRequest) {

        if (taiKhoanRepository.findByTaiKhoan(taiKhoanRequest.getTaiKhoan())!= null){
            throw  new GeneralException(RESPONSE.CODE.C409,
                    RESPONSE.MESSAGE.C409_ACCOUNT);

        }

        TaiKhoan newAcc = new TaiKhoan();

        BeanUtils.copyProperties(taiKhoanRequest, newAcc);

        newAcc.setNgayTao(new Timestamp(System.currentTimeMillis()));

        newAcc.setNgaySua(Constant.DATE_DEFAULT);
        newAcc.setNguoiSua(Constant.INFO_DEFAULT);
        newAcc.setGioiTinh(gioiTinhRepository.findByID(taiKhoanRequest.getGioiTinh()));
        newAcc.setTrangThai(trangThaiRepository.findByID(1));
        //ma hoa mat khau
        newAcc.setMatKhau(encoder.encode(taiKhoanRequest.getMatKhau()));
        //them tap quyen
        Set<Quyen> quyens = new HashSet<>();
        for (Integer id : taiKhoanRequest.getIds()) {
            quyens.add(quyenRopository.findByID(id));
        }
        newAcc.setQuyenSet(quyens);
        newAcc = taiKhoanRepository.save(newAcc);

        return new ActionDTO(ImmutableMap.builder()
                .put(vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE.JSON_VALUE.VALUE_RETURN, newAcc.getID())
                .build()
        );
    }

    @Override
    public ActionDTO update(TaiKhoanRequest taiKhoanRequest) {

        TaiKhoan newAcc = new TaiKhoan();

        TaiKhoan oldAcc = taiKhoanRepository.findByID(taiKhoanRequest.getID());

        if (oldAcc == null) {

            throw new GeneralException(RESPONSE.CODE.C404, RESPONSE.MESSAGE.C404_ACCOUNT);
        }

        BeanUtils.copyProperties(taiKhoanRequest, newAcc);

        newAcc.setNgaySua(new Timestamp(System.currentTimeMillis()));

        newAcc.setGioiTinh(gioiTinhRepository.findByID(taiKhoanRequest.getGioiTinh()));

        newAcc.setTrangThai(trangThaiRepository.findByID(taiKhoanRequest.getTrangThai()));

        newAcc.setNgayTao(oldAcc.getNgayTao());
        //ma hoa mat khau
        newAcc.setMatKhau(encoder.encode(taiKhoanRequest.getMatKhau()));
        //them tap quyen
        Set<Quyen> quyens = new HashSet<>();
        Set<Integer> ids = taiKhoanRequest.getIds();
        ids.forEach(obj -> {
            quyens.add(quyenRopository.findByID(obj));
        });
        newAcc.setQuyenSet(quyens);
        newAcc = taiKhoanRepository.save(newAcc);

        return new ActionDTO(ImmutableMap.builder()
                .put(vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE.JSON_VALUE.VALUE_RETURN, newAcc.getID())
                .build()
        );
    }

    @Override
    public ActionDTO delete(Long id) {

        TaiKhoan taiKhoan = taiKhoanRepository.findByID(id);

        if (taiKhoan == null){

            throw new GeneralException(RESPONSE.CODE.C404,RESPONSE.MESSAGE.C404_ACCOUNT);
        }

        taiKhoan.getQuyenSet().forEach(obj ->
            obj.getTaiKhoanSet().remove(taiKhoan)
        );

        taiKhoanRepository.deleteById(id);

        return new ActionDTO(ImmutableMap.builder()
                .put(vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE.JSON_VALUE.VALUE_RETURN, id)
                .build()
        );
    }

    @Override
    public ActionDTO deleteMany(Long[] ids) {

        for (Long id : ids) {

             delete(id);
        }

        return new ActionDTO(ImmutableMap.builder()
                .put(vn.tuyensinh.hoctiengviet.util.Constant.RESPONSE.JSON_VALUE.VALUE_RETURN, ids)
                .build()
        );
    }

    @Override
    public List<String> getRoleNames(Long id) {

        List<String> roleNames = new ArrayList<>();
        taiKhoanRepository.findByID(id).getQuyenSet().forEach(obj ->
                roleNames.add(obj.getTenQuyen())
        );
        return roleNames;
    }

    @Override
    public Set<Integer> getRoleIds(Long id) {
        Set<Integer> roleIds = new HashSet<>();
        taiKhoanRepository.findByID(id).getQuyenSet().forEach(obj ->
                roleIds.add(obj.getID())
        );
        return roleIds;
    }

    @Autowired
    private ParesStringToTimeStamp paresStringToTimeStamp;

    @Override
    public List<TaiKhoan> searchCondition(String hoVaTen, String taiKhoan, String soDienThoai, String email,
                                          String nguoiTao, String ngayBatDau, String ngayKetThuc, Integer gioiTinh,
                                          Integer trangThai, Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo == null ? 0 : pageNo, pageSize == null ? 0 : 10,
                Sort.by("ID").descending());

        //chuyen doi thoi gian tu String qua TimeStamp
        Timestamp dateFrom, dateTo;

        if (ngayBatDau == null || ngayBatDau == "") {

            dateFrom = null;
        } else {

            dateFrom = paresStringToTimeStamp.paresStringToTimeStamp(ngayBatDau);
        }

        if (ngayKetThuc == null || ngayKetThuc == "") {

            dateTo = null;
        } else {

            dateTo = paresStringToTimeStamp.paresStringToTimeStamp(ngayKetThuc);
        }
        Page<TaiKhoan> list = taiKhoanRepository.findByCondition(
                dateFrom,
                dateTo,
                hoVaTen,
                taiKhoan,
                soDienThoai,
                email,
                nguoiTao,
                gioiTinhRepository.findByID(gioiTinh),
                trangThaiRepository.findByID(trangThai),
                pageable
        );

        return list.toList();
    }
}
