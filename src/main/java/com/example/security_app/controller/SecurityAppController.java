package com.example.security_app.controller;

import com.example.security_app.DTO.MotorcycleDTO;
import com.example.security_app.DTO.OrderCartDTO;
import com.example.security_app.model.Basket;
import com.example.security_app.model.Motorcycle;
import com.example.security_app.service.SecurityAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")

public class SecurityAppController {

    private final SecurityAppService securityAppService;

    public SecurityAppController(SecurityAppService securityAppService) {
        this.securityAppService = securityAppService;
    }

    public SecurityAppController() {
        this.securityAppService = null;
    }

    @PostMapping("/motorcycle")
    public ResponseEntity<MotorcycleDTO> addMotorcycle(@RequestBody MotorcycleDTO motorcycleDTO) {
        return new ResponseEntity<>(securityAppService.addMotorcycle(motorcycleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/motorcycles")
    public ResponseEntity<List<MotorcycleDTO>> getAllMotorcycles() {
        return ResponseEntity.ok().body(securityAppService.getAllMotorcycles());
    }


    @GetMapping("/baskets")
    @ResponseBody
    public ResponseEntity<List<Basket>> getAllBaskets() {
        return ResponseEntity.ok().body(securityAppService.getAllBaskets());
    }

    @DeleteMapping("/motorcycle/{name}")
    @ResponseBody
    public ResponseEntity<Void> removeMotorcycle(@PathVariable String name) {
        securityAppService.deleteMotorcycle(name);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/motorcycle/fromBasket/{basketName}/{motorcycleName}")
    @ResponseBody
    public ResponseEntity<Void> removeMotorcycleFromBasket(@PathVariable String basketName, @PathVariable String motorcycleName) {
        securityAppService.deleteMotorcycleFromBasket(basketName, motorcycleName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/basket/{name}")
    public ResponseEntity<Void> removeBasket(@PathVariable String name) {
        securityAppService.deleteBasket(name);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/motorcycle/toBasket/{basketName}/{motorcycleName}")
    public ResponseEntity<Void> addMotorcycleToBasket(@PathVariable String basketName, @PathVariable String motorcycleName) {
        securityAppService.addMotorcycleToBasket(basketName, motorcycleName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/motorcycles/fromBasket/{basketName}")
    public ResponseEntity<List<Motorcycle>> getAllMotorcyclesFromBasket(@PathVariable String basketName) {
        return ResponseEntity.ok().body(securityAppService.getAllMotorcyclesFromBasket(basketName));
    }

    @PostMapping("/order")
    public ResponseEntity<OrderCartDTO> addOrder(@RequestBody OrderCartDTO orderDTO) {
        return new ResponseEntity<>(securityAppService.addOrder(orderDTO), HttpStatus.CREATED);
    }

}
