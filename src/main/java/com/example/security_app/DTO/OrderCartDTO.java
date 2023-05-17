package com.example.security_app.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_ordercartDTO")
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
}
