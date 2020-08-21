package vn.tuyensinh.hoctiengviet.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncrytedPasswordUtils {


    public static String encrytePassword(String password) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(password);
    }
}
