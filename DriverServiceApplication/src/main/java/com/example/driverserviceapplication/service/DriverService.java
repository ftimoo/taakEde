package com.example.driverserviceapplication.service;

import com.example.driverserviceapplication.model.Driver;
import com.example.driverserviceapplication.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverService{
    private final DriverRepository driverRepository;



        public List<Driver> getAllDrivers() {
            return driverRepository.findAll();
        }

        public Optional<Driver> getDriverById(Long id) {
            return driverRepository.findById(id);
        }
    }


