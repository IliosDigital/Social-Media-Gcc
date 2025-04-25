package com.example.gcc_ai.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure CORS directly within HttpSecurity
        http.cors(c -> c.configurationSource(corsConfigurationSource()))
                // Configure CSRF by using the new method, you need to disable it (if needed)
                .csrf(csrf -> csrf.disable())
                // Authorization rules
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**", "/alltweets", "/complaints/**").permitAll() // Allow all requests to /api/**
                        .anyRequest().authenticated() // Secure all other requests
                );

        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); // Allow all origins
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow all HTTP methods
        configuration.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
        configuration.setAllowCredentials(false); // Do not allow credentials (set to true if needed)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration); // Apply this CORS configuration to /api/** endpoints
        return source;
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("admin")
                .password(new BCryptPasswordEncoder().encode("madhi2248"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
