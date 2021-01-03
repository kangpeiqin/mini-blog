package com.mini.blog.config;

import com.mini.blog.security.Handler.AuthFailureHandler;
import com.mini.blog.security.Handler.AuthSuccessHandler;
import com.mini.blog.Constant.SecurityConstants;
import com.mini.blog.security.filter.ClientValidateFilter;
import com.mini.blog.security.filter.PreLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;
import java.util.Arrays;

import static java.util.Collections.singletonList;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author kpq
 * @since 1.0.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AuthSuccessHandler authSuccessHandler;

    @Resource
    private AuthFailureHandler authFailureHandler;

    @Resource
    private ClientValidateFilter clientValidateFilter;

    /**
     * 密码编码器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(clientValidateFilter,UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new PreLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl(SecurityConstants.LOGIN_URL)
                .permitAll()
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
                .and().authorizeRequests()
                .antMatchers(SecurityConstants.SWAGGER_WHITELIST)
                .permitAll()
                .anyRequest().authenticated()
                .and().cors(withDefaults()).csrf().disable();

//        http.cors(withDefaults())
//                csrf是指什么
//                .csrf().disable();
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/auth/login")
//                .permitAll()
//                .and().authorizeRequests()
//                .antMatchers("/auth/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
    }


    /**
     * 关于跨域资源共享：
     * https://segmentfault.com/a/1190000019485883?utm_source=tag-newest
     *
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(singletonList("*"));
        configuration.setAllowedHeaders(singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    public static void main(String[] args) {
        String password = "123456";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }
}
