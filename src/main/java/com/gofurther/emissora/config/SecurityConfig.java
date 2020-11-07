package com.gofurther.emissora.config;

import com.gofurther.emissora.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
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
                .antMatchers(HttpMethod.POST,"/api/performer/register")
                .permitAll()
                .antMatchers(HttpMethod.GET,"/api/performer/getByEmail")
                .hasRole("USER")
                .antMatchers(HttpMethod.GET,"/api/performer/getAllBy")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/performer/searchPerformerBy")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/performer/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.POST,"/api/producer/register")
                .permitAll()
                .antMatchers(HttpMethod.GET,"/api/producer/getByEmail")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/producer/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/reservation/register")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/reservation/producer/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/reservation/performer/**")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET,"/api/reservation/dashboard/**")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .httpBasic();
        ;
    }
}
