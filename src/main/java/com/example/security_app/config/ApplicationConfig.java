package com.example.security_app.config;

import com.example.security_app.model.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class ApplicationConfig {

    private final UserRepository userRepository;

    public ApplicationConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
public UserDetailsService userDetailsService(){

    return username -> userRepository.findByEmail(username)
            .orElseThrow(()-> new UsernameNotFoundException("ni ma"));
}
}
