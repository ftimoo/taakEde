package com.example.driverserviceapplication.controller;

import com.example.driverserviceapplication.DTO.DriverRequest;
import com.example.driverserviceapplication.model.Driver;
import com.example.driverserviceapplication.repository.DriverRepository;
import com.example.driverserviceapplication.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class DriverController {
    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getAllProducts() {
        return driverService.getAllDrivers();
    }

}
