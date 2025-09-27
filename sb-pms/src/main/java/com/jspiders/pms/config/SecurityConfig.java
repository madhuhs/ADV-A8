package com.jspiders.pms.config;

import com.jspiders.pms.data.entities.UserEntity;
import com.jspiders.pms.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;


@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/**").authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

}

@Component
class AppUser implements UserDetailsService
{
    private final UserRepository userRepository;
    @Autowired
    public AppUser (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserEntity userEntity =  userRepository.findByEmail(username).orElseThrow();
      String email = userEntity.getEmail();
      String password = userEntity.getPassword();

      String role = "ROLE_"+userEntity.getRole();// ROLE_ADMIN,ROLE_USER
//        List list = new ArrayList();
//        list.add(new SimpleGrantedAuthority(role));

        //set ROLE for the user
        List<SimpleGrantedAuthority> simpleGrantedAuthorities =
                Collections.singletonList(new SimpleGrantedAuthority(role));

        User user = new User(email,password,true,true,true,true,
                simpleGrantedAuthorities);
      return user;
    }
}