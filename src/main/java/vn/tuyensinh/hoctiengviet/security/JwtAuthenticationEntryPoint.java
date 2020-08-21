//package vn.tuyensinh.hoctiengviet.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * cấu hình để trả ra lỗi khi xác thực thất bại
// * mac định ko cấu hình sẽ do spring secuirity xử nó sẽ đẩy người truy cập không hợp lệ
// * tới trang unauthor nhưng không phù hợp với project
// * chúng ta chỉ đẩy ra lỗi trên màn hình cho người dùng biết
// */
//@Component
//@Slf4j
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                         AuthenticationException e) throws IOException, ServletException {
//        log.error("Responding with unauthortication error . Message - {}",e.getMessage());
//        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
//
//    }
//}
