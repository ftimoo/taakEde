package com.example.carserviceapplication.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "car")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Data
public class Car {
    private String id;
    private String plate;
    private String model;
    private String brand;
    private BigDecimal odometer;
}
