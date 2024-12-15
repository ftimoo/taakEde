package com.example.driverserviceapplication.service;


import com.example.driverserviceapplication.model.Driver;
import com.example.driverserviceapplication.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers(){
        List<Driver> drivers = driverRepository.findAll();
        return drivers;
    }

}
