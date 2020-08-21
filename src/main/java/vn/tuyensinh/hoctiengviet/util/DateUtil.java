package vn.tuyensinh.hoctiengviet.util;

import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;
import vn.tuyensinh.hoctiengviet.constant.Constant;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class DateUtil {

    public Timestamp parseStringToTimeStamp(String str) {
        if (str == null || str == "") {
            return Constant.DATE_DEFAULT;
        } else {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(str);
                Timestamp timestamp = new Timestamp(date.getTime());
                return timestamp;
            } catch (Exception e) {
                e.printStackTrace();
                return Constant.DATE_DEFAULT;
            }
        }

    }

    public Timestamp parseStringToTimeStampEndDate(String str) {
        if (str == null || str == "") {

            return Constant.CURRENT_DATE_DEFAULT;

        } else {

            try {

                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                Date date = formatter.parse(str);

                Timestamp timestamp = new Timestamp(date.getTime());

                return timestamp;

            } catch (Exception e) {

                e.printStackTrace();

                return Constant.CURRENT_DATE_DEFAULT;
            }
        }

    }

//    public LocalDate toLocalDateFromString(String str){
//
//        try {
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//
//            LocalDate local = formatter.parse(str);
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//
//        return local;
//
//
//
//    }
}
