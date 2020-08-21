//package vn.tuyensinh.hoctiengviet.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//import vn.tuyensinh.hoctiengviet.ResponseUser.AuthInfo;
//import vn.tuyensinh.hoctiengviet.services.impl.CustomUserDetailService;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    /**
//     * lọc user thông qua method doFilterInternal
//     * xử lí chuỗi token họp lệ để lấy ra đc user, sau đó lấy tập tập quyền cửa user để check
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//
//
//        try {
//            String jwt = getJwtFromRequest(httpServletRequest);
//
//            if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {/** kiểm tra tính hợp lệ cua token*/
//
//                AuthInfo responseSession = jwtTokenProvider.getResponseSessionFromToken(jwt);
//
//                if (responseSession != null) {
//
//                    UserDetails userDetails = customUserDetailService.loadUserById(responseSession.getId());
//
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
//
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        }catch (Exception ex){
//            log.error("{}",ex);
//        }
//    }
//
//    /**
//     * lấy chuỗi Jwt token cần xử lí từ request gửi về
//     *
//     * @param rq
//     * @return
//     */
//    private String getJwtFromRequest(HttpServletRequest rq) {
//        String bearerToken = rq.getHeader("Authorization");
//
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//}
