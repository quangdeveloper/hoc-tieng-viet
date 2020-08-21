package vn.tuyensinh.hoctiengviet.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.tuyensinh.hoctiengviet.entity.TaiKhoan;
import vn.tuyensinh.hoctiengviet.repository.TaiKhoanRepository;
import vn.tuyensinh.hoctiengviet.security.UserPrincipal;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

        @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {



        TaiKhoan taiKhoan = taiKhoanRepository.findByTaiKhoan(s);

        if (taiKhoan == null) throw new UsernameNotFoundException("Không tồn tại tài khoản với username "+s);


        return new UserPrincipal(taiKhoan);
    }

    public  UserDetails loadUserById(long id){

        TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElseThrow(

                ()->new UsernameNotFoundException("Không tồn tại tài khoản với id: "+id)
        );
        return new UserPrincipal (taiKhoan);
    }
}
