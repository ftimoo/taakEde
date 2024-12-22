package com.example.carserviceapplication.DTO;

import com.example.carserviceapplication.model.Car;
import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class CarResponse {

        private String id;
        private String model;
        private String brand;

    public CarResponse(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.brand = car.getBrand();
    }
}
