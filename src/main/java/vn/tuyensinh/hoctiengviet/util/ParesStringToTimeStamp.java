package vn.tuyensinh.hoctiengviet.util;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class ParesStringToTimeStamp {

    public Timestamp paresStringToTimeStamp(String str){

        try {

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date date = formatter.parse(str);

            Timestamp timestamp = new Timestamp(date.getTime());

            return  timestamp;

        }catch (Exception e){

            e.printStackTrace();

            return null;
        }

    }
}
