package com.example.carserviceapplication.controller;

import com.example.carserviceapplication.DTO.CarRequest;
import com.example.carserviceapplication.model.Car;
import com.example.carserviceapplication.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createCar(@RequestBody CarRequest car){
        carService.createCar(car);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllProducts() {
        return carService.getAllCars();
    }

    @PutMapping
    public Object updateCar(@RequestBody Car car) {
        if (carService.updateCar(car)){
            return new ResponseEntity<>(car,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Car not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ResponseEntity<String> deleteCar(@RequestBody Car car){

        Boolean deleted =  carService.deleteCar(car);
        if (deleted){
            return new ResponseEntity<>("Car deleted",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Car not found",HttpStatus.NOT_FOUND);
    }

}
