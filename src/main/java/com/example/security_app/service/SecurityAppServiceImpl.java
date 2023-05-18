package com.example.security_app.service;

import com.example.security_app.DTO.OrderCartDTO;
import com.example.security_app.DTO.MotorcycleDTO;
import com.example.security_app.exceptions.BasketNotFoundException;
import com.example.security_app.exceptions.MotorcycleAlreadyExistException;
import com.example.security_app.exceptions.MotorcycleNotFoundException;
import com.example.security_app.exceptions.UserNotFoundException;
import com.example.security_app.model.Basket;
import com.example.security_app.model.Motorcycle;
import com.example.security_app.model.OrderCart;
import com.example.security_app.model.User;
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
            Motorcycle save = motorcycleRepository.save(MotorcycleMapper.fromDTO(motorcycleDTO));
            return MotorcycleMapper.fromEntity(save);
        }
    }

    public List<MotorcycleDTO> getAllMotorcycles(){
        return motorcycleRepository.findAll()
                .stream()
                .map(MotorcycleMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Basket> getAllBaskets() {
        return null;
    }

    @Override
    public void deleteMotorcycle(String name) {
        motorcycleRepository.findByMotorcycleName(name).orElseThrow(() ->
                new MotorcycleNotFoundException("Motorcycle not found"));
        motorcycleRepository.deleteByMotorcycleName(name);
    }

    @Override
    public void deleteBasket(String name) {basketRepository.deleteByBasketName(name);

    }

    @Override
    public void deleteMotorcycleFromBasket(String basket, String motorcycleName) {
        Basket basketEntity = basketRepository.findByBasketName(basket).orElseThrow(()
                -> new BasketNotFoundException("Basket: " + basket + ", was not found"));
        Motorcycle byMotorcycleName = motorcycleRepository.findByMotorcycleName(motorcycleName).orElseThrow(()
                -> new MotorcycleNotFoundException("Motorcycle: " + motorcycleName + " is not present in database."));
        if (!basketEntity.getMotorcycles().contains(byMotorcycleName)) {
            throw new MotorcycleNotFoundException("Motorcycle: " + motorcycleName +  " is not present.");
        }
        basketEntity.removeMotorcycleFromBasket(byMotorcycleName);
        basketRepository.save(basketEntity);
    }

    @Override
    public void clearMotorcyclesList() {motorcycleRepository.deleteAll();}

    @Override
    public void addBasket(Basket basket) {basketRepository.save(basket);}




    @Override
    public void addMotorcycleToBasket(String basketName, String motorcycleName) {
        Basket basket = basketRepository.findByBasketName(basketName).orElseThrow(()
                -> new BasketNotFoundException("Basket" + basketName + "was not found"));
        Motorcycle motorcycle = motorcycleRepository.findByMotorcycleName(motorcycleName).orElseThrow(
                () -> new MotorcycleNotFoundException("Motorcycle: " + motorcycleName + ", was not found"));
        basket.getMotorcycles().add(motorcycle);
        basketRepository.save(basket);
    }

    @Override
    public List<Motorcycle> getAllMotorcyclesFromBasket(String basketName) {
        return basketRepository.findByBasketName(basketName)
                .orElseThrow(() -> new BasketNotFoundException("Basket: " + basketName + ", was not found."))
                .getMotorcycles();
    }


    @Override
    public OrderCartDTO addOrder(OrderCartDTO orderDTO) {
        return null;
    }
}
