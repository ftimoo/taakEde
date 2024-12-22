package com.example.driverserviceapplication;


import com.example.driverserviceapplication.model.Driver;
import com.example.driverserviceapplication.repository.DriverRepository;
import com.example.driverserviceapplication.service.DriverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DriverServiceUnitTests {
    @InjectMocks
    private DriverService driverService;

    @Mock
    private DriverRepository driverRepository;

    @Test
    public void testGetAllDrivers() {
        // Arrange
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setFirstName("Jan");
        driver.setLastName("Vertongen");
        driver.setProfilePicture("Test Pic");
        driver.setLicenceNumber("12343435");

        when(driverRepository.findAll()).thenReturn(Arrays.asList(driver));

        // Act
        List<Driver> drivers = driverService.getAllDrivers();

        // Assert
        assertEquals(1, drivers.size());
        assertEquals("Jan", drivers.get(0).getFirstName());
        assertEquals("Vertongen", drivers.get(0).getLastName());

        verify(driverRepository, times(1)).findAll();
    }

    @Test
    public void testGetDriverById() {
        // Arrange
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setFirstName("Jan");
        driver.setLastName("Vertongen");
        driver.setProfilePicture("Test Pic");
        driver.setLicenceNumber("12343435");


        when(driverRepository.findById(1L)).thenReturn(Optional.of(driver));

        // Act
        Optional<Driver> drivers = driverService.getDriverById(1L);
        Driver driver1 = null;
        // Assert
        assertEquals(drivers.isPresent(), true);
        if (drivers.isPresent()) {
            driver1 = drivers.get();  // Use .get() to extract the value
        }
        assert driver1 != null;
        assertEquals("Vertongen", driver1.getLastName());

        verify(driverRepository, times(1)).findById(1L);
    }

}