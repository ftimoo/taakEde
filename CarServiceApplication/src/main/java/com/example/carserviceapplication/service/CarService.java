package com.example.carserviceapplication.service;


import com.example.carserviceapplication.DTO.CarRequest;
import com.example.carserviceapplication.model.Car;
import com.example.carserviceapplication.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void createCar(CarRequest carRequest){
        Car car = Car.builder()
                .plate(carRequest.getPlate())
                .brand(carRequest.getBrand())
                .odometer(carRequest.getOdometer())
                .model(carRequest.getModel())
                .build();

        carRepository.save(car);
    }

    public List<Car> getAllCars(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }
    public Boolean updateCar(Car car){
        if (carRepository.findById(car.getId()).isPresent()){
            carRepository.save(car);
            return true;
        }
        return false;
    }

    public boolean deleteCarById(String id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
