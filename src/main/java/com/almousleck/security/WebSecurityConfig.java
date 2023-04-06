package com.almousleck.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
                .requestMatchers(POST,"/api/users/register").permitAll()
                .requestMatchers(GET,"/api/users/verifyEmail").permitAll()
                .and().authorizeHttpRequests()
                .requestMatchers("/api/users/all")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .and().formLogin().and().httpBasic();
        return http.build();
    }
}
