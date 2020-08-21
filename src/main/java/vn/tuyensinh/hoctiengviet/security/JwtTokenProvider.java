//package vn.tuyensinh.hoctiengviet.security;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import vn.tuyensinh.hoctiengviet.ResponseUser.AuthInfo;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.security.Security;
//import java.util.Date;
//
//@Component
//@Slf4j
//public class JwtTokenProvider {
//
//    @Value("${app.jwt.secret}")
//    private String jwtSecret;
//
//    @Value("${app.jwt.jwtExprirationInMs}")
//    private long jwtExprirationInMs;
//
//    /**
//     * chuyển dổi thông tin sang token de gửi đi
//     *
//     * @param responseSession
//     * @return
//     */
//    public String generateToken(AuthInfo responseSession) {
//        try {
//            Date now = new Date();
//            Date dateExpry = new Date(now.getTime() + jwtExprirationInMs);
//
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            return Jwts.builder()
//                    .setSubject(objectMapper.writeValueAsString(responseSession))
//                    .setExpiration(dateExpry)
//                    .setIssuedAt(new Date())
//                    .signWith(SignatureAlgorithm.ES512, jwtSecret)
//                    .compact();
//
//        } catch (Exception e) {
//
//            log.error("{}", e);
//            return null;
//        }
//
//    }
//
//    /**
//     * parse dữ liệu từ token để xử lí nghiệp vụ
//     *
//     * @param token
//     * @return
//     */
//    public AuthInfo getResponseSessionFromToken(String token) {
//
//        try {
//            Claims claims = Jwts.parser()
//                    .setSigningKey(jwtSecret)
//                    .parseClaimsJws(token)
//                    .getBody();
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            return objectMapper.readValue(claims.getSubject().getBytes(StandardCharsets.UTF_8), AuthInfo.class);
//        } catch (IOException e) {
//
//            log.error("{}", e);
//            return null;
//        }
//    }
//
//    /**
//     * Kiểm tra xem token đàu vào có hợp lệ không
//     */
//
//    public Boolean validateToken(String token) {
//
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//            return true;
//        } catch (SignatureException ex) {
//
//            log.error("Invalid JWT signature");
//        } catch (MalformedJwtException ex1) {
//
//            log.error("Invalid JWT token");
//        } catch (ExpiredJwtException ex2) {
//
//            log.error("Expired JWT token");
//        } catch (UnsupportedJwtException ex3) {
//
//            log.error("Unsupport JWT token");
//        } catch (IllegalArgumentException ex4) {
//
//            log.error("JWT claim is empty");
//        }
//        return false;
//    }
//
//    public UserPrincipal getUserInfo() {
//
//        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return (UserPrincipal) authentication.getPrincipal();
//    }
//}
