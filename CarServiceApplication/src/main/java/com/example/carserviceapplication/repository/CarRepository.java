package com.example.carserviceapplication.repository;


import com.example.carserviceapplication.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
}
