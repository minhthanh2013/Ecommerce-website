package com.doan2.spring.config;

import com.doan2.spring.service.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    MyDBAuthenticationService myDBAauthenticationService;

    @Autowired
    @Qualifier("securityDataSource")

    private DataSource securityDataSource;
    //@Autowired
    //private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;


    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new CustomAuthenticationSuccessHandler("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // auth.jdbcAuthentication().dataSource(securityDataSource);
        auth.userDetailsService(myDBAauthenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/api/**").hasRole("ADMIN")
                .antMatchers("/dashboard/**").hasAnyRole("USER","MANAGER","ADMIN")
                .antMatchers("/").hasAnyRole("USER","MANAGER","ADMIN")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/api/products/**").hasAnyRole("ADMIN", "MANAGER")
//                .antMatchers(HttpMethod.GET, "/api/product").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("ADMIN", "MANAGER")
//                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("ADMIN", "MANAGER")

                .and()

                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/authenticateTheUser")
                    .successHandler(successHandler())
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }


}
