//package vn.tuyensinh.hoctiengviet.config;
//
//import com.google.gson.Gson;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Date;
//
//
//public class JWTConfig {
//
//    static final long EXPIRATIONTIME = 3_600_000 * 24 * 30; //one month
//
//    static final String TOKEN_PREFIX = "Bearer";
//
//    static final String SECRET = "KYIVtA7915PUEWTqTca74sENpw48u7nkzSJiJmitF7D2PJWOu";
//
//    static final String HEADER_STRING = "Authorization";
//
//    static String genToken(Object user) {
//
//        Gson gson = new Gson();
//
//        String JWT = Jwts.builder()
//                .setSubject(gson.toJson(user))
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
//                .signWith(SignatureAlgorithm.ES512, SECRET)
//                .compact();
//        return JWT;
//
//    }
//
//    static String decodeToken(String token) {
//
//        String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token)
//                .getBody().getSubject();
//
//        return user;
//    }
//
//}
