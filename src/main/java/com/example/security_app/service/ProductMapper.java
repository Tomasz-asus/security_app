package com.example.security_app.service;

import com.example.security_app.DTO.ProductDTO;
import com.example.security_app.model.Product;
import lombok.Data;

@Data
public class ProductMapper {

    public static ProductDTO fromEntity(Product product) {
        return new ProductDTO(product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getImageURL(),
                product.getCategory());
    }
}
