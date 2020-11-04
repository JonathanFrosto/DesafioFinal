package com.gofurther.emissora.config;

import com.gofurther.emissora.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/performer/register")
                .permitAll()
                .antMatchers("/api/performer/getAllBy")
                .hasRole("ADMIN")
                .antMatchers("/api/performer/searchPerformerBy")
                .hasRole("ADMIN")
                .antMatchers("/api/producer/register")
                .permitAll()
                .antMatchers("/api/reservation/register")
                .hasRole("ADMIN")
                .antMatchers("/api/reservation/producer/**")
                .hasRole("ADMIN")
                .antMatchers("/api/reservation/performer/**")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/reservation/dashboard/**")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .httpBasic();
        ;
    }
}
