package com.example.security_app.service;

import com.example.security_app.DTO.MotorcycleDTO;
import com.example.security_app.DTO.OrderCartDTO;
import com.example.security_app.exceptions.BasketNotFoundException;
import com.example.security_app.exceptions.MotorcycleAlreadyExistException;
import com.example.security_app.exceptions.MotorcycleNotFoundException;
import com.example.security_app.model.Basket;
import com.example.security_app.model.Motorcycle;
import com.example.security_app.repository.BasketRepository;
import com.example.security_app.repository.MotorcycleRepository;
import com.example.security_app.repository.OrderCartRepository;
import com.example.security_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SecurityAppServiceImpl implements SecurityAppService {


    private final MotorcycleRepository motorcycleRepository;

    private final BasketRepository basketRepository;

    private final OrderCartRepository orderCartRepository;

    private final UserRepository userRepository;

    public SecurityAppServiceImpl(MotorcycleRepository motorcycleRepository, BasketRepository basketRepository, OrderCartRepository orderCartRepository, UserRepository userRepository) {
        this.motorcycleRepository = motorcycleRepository;
        this.basketRepository = basketRepository;
        this.orderCartRepository = orderCartRepository;
        this.userRepository = userRepository;
    }

    public SecurityAppServiceImpl() {
        this.motorcycleRepository = null;
        this.basketRepository = null;
        this.orderCartRepository = null;
        this.userRepository = null;
    }

    public static SecurityAppServiceImplBuilder builder() {
        return new SecurityAppServiceImplBuilder();
    }


    @Override
    public MotorcycleDTO addMotorcycle(MotorcycleDTO motorcycleDTO) {
        if (motorcycleRepository.findByMotorcycleName(motorcycleDTO.getMotorcycleName()).isPresent()) {
            throw new MotorcycleAlreadyExistException("Motorcycle Already Exist");
        } else {
            Motorcycle save = motorcycleRepository.save(MotorcycleMapper.fromDTO(motorcycleDTO));
            return MotorcycleMapper.fromEntity(save);
        }
    }

    public List<MotorcycleDTO> getAllMotorcycles() {
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
    public void deleteBasket(String name) {
        basketRepository.deleteByBasketName(name);

    }

    @Override
    public void deleteMotorcycleFromBasket(String basket, String motorcycleName) {
        Basket basketEntity = basketRepository.findByBasketName(basket).orElseThrow(()
                -> new BasketNotFoundException("Basket: " + basket + ", was not found"));
        Motorcycle byMotorcycleName = motorcycleRepository.findByMotorcycleName(motorcycleName).orElseThrow(()
                -> new MotorcycleNotFoundException("Motorcycle: " + motorcycleName + " is not present in database."));
        if (!basketEntity.getMotorcycles().contains(byMotorcycleName)) {
            throw new MotorcycleNotFoundException("Motorcycle: " + motorcycleName + " is not present.");
        }
        basketEntity.removeMotorcycleFromBasket(byMotorcycleName);
        basketRepository.save(basketEntity);
    }

    @Override
    public void clearMotorcyclesList() {
        motorcycleRepository.deleteAll();
    }

    @Override
    public void addBasket(Basket basket) {
        basketRepository.save(basket);
    }


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

    public MotorcycleRepository getMotorcycleRepository() {
        return this.motorcycleRepository;
    }

    public BasketRepository getBasketRepository() {
        return this.basketRepository;
    }

    public OrderCartRepository getOrderCartRepository() {
        return this.orderCartRepository;
    }

    public UserRepository getUserRepository() {
        return this.userRepository;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SecurityAppServiceImpl)) return false;
        final SecurityAppServiceImpl other = (SecurityAppServiceImpl) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$motorcycleRepository = this.getMotorcycleRepository();
        final Object other$motorcycleRepository = other.getMotorcycleRepository();
        if (this$motorcycleRepository == null ? other$motorcycleRepository != null : !this$motorcycleRepository.equals(other$motorcycleRepository))
            return false;
        final Object this$basketRepository = this.getBasketRepository();
        final Object other$basketRepository = other.getBasketRepository();
        if (this$basketRepository == null ? other$basketRepository != null : !this$basketRepository.equals(other$basketRepository))
            return false;
        final Object this$orderCartRepository = this.getOrderCartRepository();
        final Object other$orderCartRepository = other.getOrderCartRepository();
        if (this$orderCartRepository == null ? other$orderCartRepository != null : !this$orderCartRepository.equals(other$orderCartRepository))
            return false;
        final Object this$userRepository = this.getUserRepository();
        final Object other$userRepository = other.getUserRepository();
        if (this$userRepository == null ? other$userRepository != null : !this$userRepository.equals(other$userRepository))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SecurityAppServiceImpl;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $motorcycleRepository = this.getMotorcycleRepository();
        result = result * PRIME + ($motorcycleRepository == null ? 43 : $motorcycleRepository.hashCode());
        final Object $basketRepository = this.getBasketRepository();
        result = result * PRIME + ($basketRepository == null ? 43 : $basketRepository.hashCode());
        final Object $orderCartRepository = this.getOrderCartRepository();
        result = result * PRIME + ($orderCartRepository == null ? 43 : $orderCartRepository.hashCode());
        final Object $userRepository = this.getUserRepository();
        result = result * PRIME + ($userRepository == null ? 43 : $userRepository.hashCode());
        return result;
    }

    public String toString() {
        return "SecurityAppServiceImpl(motorcycleRepository=" + this.getMotorcycleRepository() + ", basketRepository=" + this.getBasketRepository() + ", orderCartRepository=" + this.getOrderCartRepository() + ", userRepository=" + this.getUserRepository() + ")";
    }

    public static class SecurityAppServiceImplBuilder {
        private MotorcycleRepository motorcycleRepository;
        private BasketRepository basketRepository;
        private OrderCartRepository orderCartRepository;
        private UserRepository userRepository;

        SecurityAppServiceImplBuilder() {
        }

        public SecurityAppServiceImplBuilder motorcycleRepository(MotorcycleRepository motorcycleRepository) {
            this.motorcycleRepository = motorcycleRepository;
            return this;
        }

        public SecurityAppServiceImplBuilder basketRepository(BasketRepository basketRepository) {
            this.basketRepository = basketRepository;
            return this;
        }

        public SecurityAppServiceImplBuilder orderCartRepository(OrderCartRepository orderCartRepository) {
            this.orderCartRepository = orderCartRepository;
            return this;
        }

        public SecurityAppServiceImplBuilder userRepository(UserRepository userRepository) {
            this.userRepository = userRepository;
            return this;
        }

        public SecurityAppServiceImpl build() {
            return new SecurityAppServiceImpl(this.motorcycleRepository, this.basketRepository, this.orderCartRepository, this.userRepository);
        }

        public String toString() {
            return "SecurityAppServiceImpl.SecurityAppServiceImplBuilder(motorcycleRepository=" + this.motorcycleRepository + ", basketRepository=" + this.basketRepository + ", orderCartRepository=" + this.orderCartRepository + ", userRepository=" + this.userRepository + ")";
        }
    }
}
