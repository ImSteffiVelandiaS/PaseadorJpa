package com.example.Udea.Paseador.Config;

import com.example.Udea.Paseador.Entidades.User;
import com.example.Udea.Paseador.JWT.JwtAutenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


        private  final JwtAutenticationFilter jwtAutenticationFilter;
        private  final AuthenticationProvider authProvider;
            @Bean
            public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http
                        .csrf(csrf -> csrf.disable()) // Deshabilita CSRF
                        .authorizeHttpRequests(authRequest -> authRequest
                                .requestMatchers("/auth/**").permitAll() // Permite acceso público a /auth/**
                                .anyRequest().authenticated() // Protege el resto de rutas
                        )
                        .sessionManagement(sessionManager->
                                sessionManager
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authenticationProvider(authProvider)
                        .addFilterBefore(jwtAutenticationFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
            }
        }
