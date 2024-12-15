package com.example.driverserviceapplication.controller;

import com.example.driverserviceapplication.model.Driver;
import com.example.driverserviceapplication.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getAllOrders() {
        return driverService.getAllDrivers();
    }
}
