package com.example.carserviceapplication.service;


import com.example.carserviceapplication.DTO.CarRequest;
import com.example.carserviceapplication.DTO.CarResponse;
import com.example.carserviceapplication.model.Car;
import com.example.carserviceapplication.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<CarResponse> getAllCars(){
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(car -> new CarResponse(car))
                .collect(Collectors.toList());
    }

    public Optional<Car> getCarById(String id) {
        Optional<Car> carOptional = carRepository.findById(id);
        return carOptional;
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
