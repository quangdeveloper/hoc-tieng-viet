package vn.tuyensinh.hoctiengviet.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import vn.tuyensinh.hoctiengviet.entity.UserAuditModel;
import vn.tuyensinh.hoctiengviet.security.UserPrincipal;

public class SecurityUtil {


    public SecurityUtil() {
    }

    public static long getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {

            final Object o = authentication.getPrincipal();

            if (o instanceof UserPrincipal) {

                UserPrincipal userPrincipal = (UserPrincipal) o;

                return userPrincipal.getId();
            }
        }

        return 0L;
    }

    public static UserAuditModel getUserAuditModel() {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {

            final Object obj = authentication.getPrincipal();

            if (obj instanceof UserPrincipal) {

                UserPrincipal userPrincipal = (UserPrincipal) obj;

                return UserAuditModel.builder()
                        .id(userPrincipal.getId())
                        .username(userPrincipal.getUsername())
                        .build();
            }
        }
        return new UserAuditModel();
    }

}
