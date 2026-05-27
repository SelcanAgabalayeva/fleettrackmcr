package com.selcan.vehicle_service.security;

import com.selcan.vehicle_service.security.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .sessionManagement(sm ->
                        sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(auth -> auth

                        // Swagger
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/webjars/**"
                        ).permitAll()

                        // GET -> USER + ADMIN
                        .requestMatchers(org.springframework.http.HttpMethod.GET,
                                "/vehicles/**"
                        ).hasAnyRole("USER", "ADMIN")

                        // POST -> ADMIN
                        .requestMatchers(org.springframework.http.HttpMethod.POST,
                                "/vehicles/**"
                        ).hasRole("ADMIN")

                        // PUT -> ADMIN
                        .requestMatchers(org.springframework.http.HttpMethod.PUT,
                                "/vehicles/**"
                        ).hasRole("ADMIN")

                        // DELETE -> ADMIN
                        .requestMatchers(org.springframework.http.HttpMethod.DELETE,
                                "/vehicles/**"
                        ).hasRole("ADMIN")

                        .anyRequest().authenticated()
                )

                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}