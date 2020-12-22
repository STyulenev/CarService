package com.carservice.application.configuration;

import com.carservice.application.configuration.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/carservice/customer/*").hasRole("ADMIN")
                .antMatchers("/carservice/detail/update/*").hasRole("ADMIN")
                .antMatchers("/carservice/office/update/*").hasRole("ADMIN")
                .antMatchers("/carservice/warehouseupdate/*").hasRole("ADMIN")
                .antMatchers("/carservice/detail/get/*").hasRole("USER")
                .antMatchers("/carservice/office/get/*").hasRole("USER")
                .antMatchers("/carservice/warehouse/get/*").hasRole("USER")
                .antMatchers("/carservice/registration", "/carservice/authorization").permitAll()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
