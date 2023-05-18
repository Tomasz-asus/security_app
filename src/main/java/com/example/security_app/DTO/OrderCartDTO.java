package com.example.security_app.DTO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "_orderCartDTO")
public class OrderCartDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstAndLastName;
    private String street;
    private String postalCode;
    private String city;
    private Integer phoneNumber;
    private LocalDateTime orderDate;
    private String username;
    private String basketName;

    public OrderCartDTO(String username, String firstAndLastName, String basketName, String street, String postalCode, String city, Integer phoneNumber) {
    }
}
