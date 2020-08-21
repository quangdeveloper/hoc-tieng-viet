package vn.tuyensinh.hoctiengviet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import vn.tuyensinh.hoctiengviet.security.JwtAuthenticationEntryPoint;
//import vn.tuyensinh.hoctiengviet.security.JwtAuthenticationFilter;
import vn.tuyensinh.hoctiengviet.services.impl.CustomUserDetailService;

public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    private CustomUserDetailService customUserDetailService;


    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    private JwtAuthenticationEntryPoint unauthorizedHandler;
//
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }

    @Value("${app.noneAuthen}")
    private String noneAuthen;


    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] noneAuthens = noneAuthen.split("\\|");
        http
                .cors().disable()
//                .and()
                .csrf()
                .disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(unauthorizedHandler)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .authorizeRequests().anyRequest().permitAll();
//                .antMatchers("/",
//                        "/ews",
//                        "/favicon.ico",
//                        "/**/*.png",
//                        "/**/*.gif",
//                        "/**/*.svg",
//                        "/**/*.jpg",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js",
//                        "/v2/api-docs",
//                        "/swagger-resources",
//                        "/swagger-resources/**",
//                        "/configuration/ui",
//                        "/configuration/security",
//                        "/swagger-ui.html",
//                        "/webjars/**")
//                .permitAll()
//                .antMatchers("/auth/**", "/user/login", "/ews/**")
//                .permitAll()
//                .antMatchers(noneAuthens)
//                .permitAll()
//                .antMatchers("/iot/gateway/nonAuthen/**")
//                .permitAll()
//                .antMatchers(HttpMethod.GET).permitAll()
//                .anyRequest()
//                .authenticated();

//        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
