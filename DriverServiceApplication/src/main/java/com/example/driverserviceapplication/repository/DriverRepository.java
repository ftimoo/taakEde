package com.example.driverserviceapplication.repository;


import com.example.driverserviceapplication.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
