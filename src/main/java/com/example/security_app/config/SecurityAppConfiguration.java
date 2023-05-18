package com.example.security_app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityAppConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    public SecurityAppConfiguration(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider, LogoutHandler logoutHandler) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationProvider = authenticationProvider;
        this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/shop/**"
                        // "/shop/auth/**"
                )
                .permitAll()

//
//                .requestMatchers("/shop/management/**")
//                .hasAnyRole(
//                        ADMIN.name(),
//                        MANAGER.name(),
//                        USER.name())
//
//
//                .requestMatchers(GET, "/shop/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name(), USER_READ.name())
//                .requestMatchers(POST, "/shop/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name(),USER_CREATE.name())
//                .requestMatchers(PUT, "/shop/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name(),USER_UPDATE.name())
//                .requestMatchers(DELETE, "/shop/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name(), USER_DELETE.name())
//
//

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/shop/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        ;

        return http.build();
    }
}