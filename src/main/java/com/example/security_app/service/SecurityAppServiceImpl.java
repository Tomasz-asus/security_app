package com.example.security_app.service;

import com.example.security_app.DTO.OrderCartDTO;
import com.example.security_app.DTO.MotorcycleDTO;
import com.example.security_app.exceptions.MotorcycleAlreadyExistException;
import com.example.security_app.model.Basket;
import com.example.security_app.model.Motorcycle;
import com.example.security_app.repository.BasketRepository;
import com.example.security_app.repository.OrderCartRepository;
import com.example.security_app.repository.MotorcycleRepository;
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


    private final MotorcycleRepository motorcycleRepository;

    private final BasketRepository basketRepository;

    private final OrderCartRepository orderCartRepository;

    private final UserRepository userRepository;


    @Override
    public MotorcycleDTO addMotorcycle(MotorcycleDTO motorcycleDTO) {
        if (motorcycleRepository.findByMotorcycleName(motorcycleDTO.getMotorcycleName()).isPresent()) {
            throw new MotorcycleAlreadyExistException("Motorcycle Already Exist");
        } else {
            Motorcycle save = motorcycleRepository.save(ProductMapper.fromDTO(motorcycleDTO));
            return ProductMapper.fromEntity(save);
        }
    }

    public List<MotorcycleDTO> getAllMotorcycles(){
        return motorcycleRepository.findAll()
                .stream()
                .map(ProductMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Basket> getAllBaskets() {
        return null;
    }

    @Override
    public void deleteMotorcycle(String name) {

    }

    @Override
    public void deleteBasket(String name) {

    }

    @Override
    public void deleteMotorcycleFromBasket(String basket, String motorcycleName) {

    }

    @Override
    public void clearMotorcyclesList() {

    }

    @Override
    public void addBasket(Basket basket) {

    }

    @Override
    public void addMotorcycleToBasket(String basketName, String motorcycleName) {

    }

    @Override
    public List<Motorcycle> getAllMotorcyclesFromBasket(String basketName) {
        return null;
    }

    @Override
    public OrderCartDTO addOrder(OrderCartDTO orderDTO) {
        return null;
    }
}
