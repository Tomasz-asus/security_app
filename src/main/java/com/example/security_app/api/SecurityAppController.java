package com.example.security_app.api;

import com.example.security_app.service.SecurityAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/motoShop")
@RequiredArgsConstructor
public class SecurityAppController {

    private final SecurityAppService securityAppService;
}
