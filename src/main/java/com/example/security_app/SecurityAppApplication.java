package com.example.security_app;

import com.example.security_app.service.AuthenticationService;
import com.example.security_app.controller.RegisterRequestUser;
import com.example.security_app.repository.MotorcycleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
;
import static com.example.security_app.model.Role.ADMIN;
import static com.example.security_app.model.Role.MANAGER;

@SpringBootApplication
public class SecurityAppApplication {
    private final MotorcycleRepository motorcycleRepository;

    public SecurityAppApplication(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequestUser.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequestUser.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("manager@mail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };
    }

}

