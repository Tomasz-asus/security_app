package com.example.security_app.service;

import com.example.security_app.DTO.ProductDTO;
import com.example.security_app.repository.BasketRepository;
import com.example.security_app.repository.OrderCartRepository;
import com.example.security_app.repository.ProductRepository;
import com.example.security_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Service
@Transactional
public class SecurityAppServiceImpl implements SecurityAppService{


    private final ProductRepository productRepository;

    private final BasketRepository basketRepository;

    private final OrderCartRepository orderCartRepository;

    private final UserRepository userRepository;


    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::fromEntity)
                .collect(Collectors.toList());
    }

}
