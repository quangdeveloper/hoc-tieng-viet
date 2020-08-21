package vn.tuyensinh.hoctiengviet.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UploadPictureUtil {

    private String doUpload(MultipartFile[] dataFiles) {

        // set ten thu muc luu tru anh tai len
        File uploadRootDir = new File("..\\DATN\\TuyenSinhHocTiengViet\\src\\main\\webapp\\pictures");

        // Tạo thư mục gốc upload nếu nó không tồn tại.  D:\DATN\TuyenSinhHocTiengViet\src\main\webapp\pictures
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }

//        lay danh sach file muon luu tu form upload
        MultipartFile[] fileDatas = dataFiles;

        List<String > listData= new ArrayList<>();
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

}
