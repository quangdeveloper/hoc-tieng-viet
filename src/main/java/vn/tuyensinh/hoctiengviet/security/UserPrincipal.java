package vn.tuyensinh.hoctiengviet.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private long id;

    private String username;

    @JsonIgnore
    private String password;

    Collection<? extends GrantedAuthority> grandList;


    public long getId() {
        return id;
    }

    private boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grandList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public UserPrincipal(final TaiKhoan taiKhoan) {

        List<GrantedAuthority> grandList = taiKhoan.getQuyenSet().stream().map(
                role -> new SimpleGrantedAuthority("ROLE_"+role.getTenQuyen())
        ).collect(Collectors.toList());

        this.id = taiKhoan.getID();
        this.username = taiKhoan.getTaiKhoan();
        this.password = taiKhoan.getMatKhau();
        this.grandList = grandList;
        if (taiKhoan.getTrangThai().getID() == 1) {

            this.active = true;
        } else {

            this.active = false;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (this != obj || this.getClass() != obj.getClass()) return false;

        UserPrincipal userPrincipal = (UserPrincipal) obj;
        return Objects.equals(id, userPrincipal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
