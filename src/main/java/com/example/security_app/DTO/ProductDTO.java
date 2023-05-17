package com.example.security_app.DTO;

import com.example.security_app.model.ProductCategory;
import jakarta.persistence.Entity;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private String productName;
    private String productDescription;
    private Double productPrice;
    private String imageURL;
    private ProductCategory category;
}
