package com.example.carserviceapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "car")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Car {
    private String id;
    private String plate;
    private String model;
    private String brand;
    private BigDecimal odometer;
}
