package vn.tuyensinh.hoctiengviet.services.impl;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.tuyensinh.hoctiengviet.dto.ActionDTO;
import vn.tuyensinh.hoctiengviet.dto.PageDTO;
import vn.tuyensinh.hoctiengviet.dto.PictureDTO;
import vn.tuyensinh.hoctiengviet.dto.PictureNewDTO;
import vn.tuyensinh.hoctiengviet.dto.apiParam.GetListPictureParam;
import vn.tuyensinh.hoctiengviet.dto.apiParam.PageParam;
import vn.tuyensinh.hoctiengviet.entity.Picture;
import vn.tuyensinh.hoctiengviet.exception.GeneralException;
import vn.tuyensinh.hoctiengviet.mapper.PictureMapper;
import vn.tuyensinh.hoctiengviet.repository.PictureRepository;
import vn.tuyensinh.hoctiengviet.services.PictureService;
import vn.tuyensinh.hoctiengviet.util.Constant;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public ActionDTO addPicture(PictureNewDTO p) {

        Picture newP = new Picture();

        newP.setDescription(p.getDescription());

        newP.setLinkImage(upload(p.getMultipartFile()));

        newP.setName(autoKey());

        newP.setIsActive(true);

        newP = pictureRepository.save(newP);

        return new ActionDTO(ImmutableMap.builder()
                .put(Constant.RESPONSE.JSON_VALUE.VALUE_RETURN, newP.getId())
                .build()
        );
    }

    @Override
    public ActionDTO deletePicture(Long id) {

        Picture p = pictureRepository.findById(id).orElseThrow(

                () -> new GeneralException(Constant.RESPONSE.CODE.C404,
                        Constant.RESPONSE.MESSAGE.C404_PICTURE)
        );

        p.setIsActive(false);

        return new ActionDTO(ImmutableMap.builder()
                .put(Constant.RESPONSE.JSON_VALUE.VALUE_RETURN, p.getId())
                .build()
        );
    }

    @Override
    public PageDTO findAll(PageParam p) {

        Pageable pageable = PageRequest.of(p.getPageNo() - 1, p.getPageSize(), Sort.by("id").descending());

        Page<Picture> page = pictureRepository.findAll(pageable);

        List<PictureDTO> list = page.map(pictureMapper::toPictureDTOFromPicture).getContent();

        final long total = page.getTotalElements();

        return PageDTO.builder()
                .content(list)
                .total(total)
                .build();
    }

    @Override
    public PageDTO findByStatus(GetListPictureParam p) {

        Pageable pageable = PageRequest.of(p.getPageNo() - 1, p.getPageSize(), Sort.by("id").descending());

        Page<Picture> page = null;

        if (p.getStatus() == 1) {

             page = pictureRepository.findByStatus(pageable, true);
        }else {
            page = pictureRepository.findByStatus(pageable, false);

        }

        if (page == null){
            throw new GeneralException(Constant.RESPONSE.CODE.C404,Constant.RESPONSE.MESSAGE.C404_PICTURE);
        }

        List<PictureDTO> list = page.map(pictureMapper::toPictureDTOFromPicture).getContent();

        final long total = page.getTotalElements();

        return PageDTO.builder()
                .content(list)
                .total(total)
                .build();
    }

    @Override
    public String upload(MultipartFile[] multipartFiles) {
/**Thư mục gốc upload file.
 *
 String uploadRootPath = request.getServletContext().getRealPath("upload");
 System.out.println("uploadRootPath=" + uploadRootPath);
 File uploadRootDir = new File(uploadRootPath);

 */
        // set ten thu muc luu tru anh tai len
        File uploadRootDir = new File("src\\main\\webapp\\pictures");

        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }

//        lay danh sach file muon luu tu form upload
        MultipartFile[] fileDatas = multipartFiles;

        List<String> listData = new ArrayList<>();
        //xu li danh sach yeu cau file upload gui ve
        for (MultipartFile fileData : fileDatas) {

            // Tên file gốc tại Client.
            //(khong bao gom dia chi thu muc) ten nay co the su dung de luu xuong DB
            String name = fileData.getOriginalFilename();

            listData.add(name);
            //kiem tra neu ten null or empty
            if (name != null && name.length() > 0) {

                try {
                    // Tạo file tại Server.
                    // uploadRootDir.getAbsolutePath() lay ten duong dan thu muc luu tru
                    // File.separator tao '/' khi gop hai phan cua duong dan
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

                    // luu file dc upload len thong qua bufferedOutputStream
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());// luu thong qua method write()
                    stream.close();//dong thread khi luu xong
                    //
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                }
            }
        }

        //tra ra giao dien trang sau khi da xu li luu file
        return listData.get(0);
    }


    private String autoKey() {

        LocalDate localDate = LocalDate.now();

        StringBuilder str = new StringBuilder("PictureDay:");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        str.append(timestamp.toString());

        return str.toString();
    }
}
