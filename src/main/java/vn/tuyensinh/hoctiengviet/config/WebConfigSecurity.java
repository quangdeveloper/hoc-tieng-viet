package vn.tuyensinh.hoctiengviet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import vn.tuyensinh.hoctiengviet.constant.Constant;
import vn.tuyensinh.hoctiengviet.constant.ConstantRole;
import vn.tuyensinh.hoctiengviet.services.impl.CustomUserDetailService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class
WebConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;



    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //tat bao ve he thong cua spring security
        http.csrf().disable();

        http.authorizeRequests().antMatchers("/login", "/logout", "/v1/web/**").permitAll();

//        http.authorizeRequests().antMatchers("/v1/admin/**")
//                .access("hasAnyRole('SYSTEM_MANAGER')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/v1/admin/home")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout")
                .logoutSuccessUrl("/v1/web");

        http.authorizeRequests().and().rememberMe()
                .tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(7 * 24 * 60 * 60);
    }


    // Token stored in Memory (Of Web Server).
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

}
