package com.example.driverserviceapplication.controller;

import com.example.driverserviceapplication.model.Driver;
import com.example.driverserviceapplication.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllOrders(@RequestParam(value = "id", required = false) Long id) {

        if (id != null) {
            return driverService.getDriverById(id)
                    .map(driver -> new ResponseEntity<>(driver, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(driverService.getAllDrivers(), HttpStatus.OK);

    }
}
