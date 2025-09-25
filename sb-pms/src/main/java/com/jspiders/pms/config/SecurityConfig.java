package com.jspiders.pms.config;

import com.jspiders.pms.data.entities.UserEntity;
import com.jspiders.pms.data.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // DB-backed auth
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            UserEntity u = userRepository.findByEmail(username).orElseThrow();

            return new User(
                    u.getEmail(),
                    u.getPassword(),     // must be BCrypt-encoded in DB
                    u.isActive(),        // enabled
                    true,                // accountNonExpired
                    true,                // credentialsNonExpired
                    true,                // accountNonLocked
                    Collections.emptyList() // <-- no authorities
            );
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/**")
                        .permitAll()  // open
                        .anyRequest().authenticated()               // just be logged in
                )
                .csrf(csrf -> csrf.disable())                   // fine for pure REST; enable for forms
                .httpBasic(Customizer.withDefaults());          // or .formLogin(Customizer.withDefaults());

        return http.build();
    }
}