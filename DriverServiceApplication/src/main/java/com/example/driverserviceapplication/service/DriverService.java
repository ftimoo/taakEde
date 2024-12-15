package com.example.driverserviceapplication.service;

import com.example.driverserviceapplication.model.Driver;
import com.example.driverserviceapplication.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverService{
    private final DriverRepository driverRepository;


    public List<Driver> getAllDrivers() {
        List<Driver> drivers = driverRepository.findAll();

        //return drivers.stream().map(order -> new OrderResponse(order.getOrderNumber(),mapToOrderLineItemsDto(order.getOrderLineItemsList()))).collect(Collectors.toList());
        return drivers;
    }

}