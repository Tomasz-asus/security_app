package com.example.security_app;


import com.example.security_app.service.AuthenticationService;
import com.example.security_app.controller.RegisterRequestUser;

import com.example.security_app.service.SecurityAppServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.security_app.model.Role.*;

@SpringBootApplication
public class SecurityAppApplication {


    public static void main(String[] args) {
        SpringApplication.run(SecurityAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service, SecurityAppServiceImpl service2
            ) {
        return args -> {
            var admin = RegisterRequestUser.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@gmail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var user = RegisterRequestUser.builder()
                    .firstname("User")
                    .lastname("User")
                    .email("user@mail.com")
                    .password("password")
                    .role(USER)
                    .build();
            System.out.println("USER token: " + service.register(user).getAccessToken());



        };
    }

}

