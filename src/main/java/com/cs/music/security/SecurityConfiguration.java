package com.cs.music.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;
    @Value("${cs.music.file.static-access-path:''}")
    public String staticAccessPath;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //static resources configuration
                .antMatchers("/resources/**", "/webjars/**", "/img/**", "/music/**").permitAll()
                //login page and registration end-point
                .antMatchers("/login", "/registration").permitAll()
                //开放页面
                .antMatchers(staticAccessPath, "/mediafile/**", "/file/**", "/public/**", "**/public/**", "/test/**", "/view/**").permitAll()
                //all other requests
                .anyRequest().authenticated()
                .and()
                // login form configuration
                .formLogin()
                .loginPage("/view/index")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                //logout configuration
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
