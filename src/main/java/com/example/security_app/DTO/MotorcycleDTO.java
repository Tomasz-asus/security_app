package com.example.security_app.DTO;

import com.example.security_app.model.MotorcycleCategory;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MotorcycleDTO {

    private String motorcycleName;
    private String motorcycleDescription;
    private Double motorcyclePrice;
    private String imageURL;
    private MotorcycleCategory category;
}
