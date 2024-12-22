package com.example.carserviceapplication;

import com.example.carserviceapplication.DTO.CarResponse;
import com.example.carserviceapplication.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.carserviceapplication.DTO.CarRequest;
import com.example.carserviceapplication.model.Car;
import com.example.carserviceapplication.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CarServiceApplicationTests {

		@Mock
		private CarRepository carRepository;

		@InjectMocks
		private CarService carService;

	@Test
	public void testCreateCar() {
		// Arrange
		CarRequest carRequest = new CarRequest("123ABC", "Toyota", "Corolla", 50000);

		// Act
		carService.createCar(carRequest);

		// Assert
		verify(carRepository, times(1)).save(any(Car.class));
	}

	// Test for getAllCars
	@Test
	public void testGetAllCars() {
		// Arrange
		Car car1 = new Car("1", "123ABC", "Toyota", "Corolla", 50000);
		Car car2 = new Car("2", "456DEF", "Honda", "Civic", 50000);
		List<Car> carList = Arrays.asList(car1, car2);

		when(carRepository.findAll()).thenReturn(carList);

		// Act
		List<CarResponse> carResponses = carService.getAllCars();

		// Assert
		assertEquals(2, carResponses.size());
		assertEquals("Toyota", carResponses.get(0).getModel());
		assertEquals("Honda", carResponses.get(1).getModel());
	}

	// Test for getCarById
	@Test
	public void testGetCarById_found() {
		// Arrange
		Car car = new Car("1", "123ABC", "Toyota", "Corolla", 50000);
		when(carRepository.findById("1")).thenReturn(Optional.of(car));

		// Act
		Optional<Car> foundCar = carService.getCarById("1");

		// Assert
		assertTrue(foundCar.isPresent());
	}

	@Test
	public void testGetCarById_notFound() {
		// Arrange
		when(carRepository.findById("1")).thenReturn(Optional.empty());

		// Act
		Optional<Car> foundCar = carService.getCarById("1");

		// Assert
		assertFalse(foundCar.isPresent());
	}
	@BeforeEach
	public void setUp() {
		// Simulating the behavior of saving the car
		Car car = new Car("1", "123ABC", "Toyota", "Corolla", 50000);

		// Mocking the findById to return the car
		when(carRepository.findById("1")).thenReturn(Optional.of(car));

		// Mocking existsById to return true, assuming the car exists
		when(carRepository.existsById("1")).thenReturn(true);

		// Mocking save to do nothing, as it's just a test (we don't need actual persistence)
		when(carRepository.save(car)).thenReturn(car);  // Simulating a successful save
	}

	// Test for updateCar
	@Test
	public void testUpdateCar() {
		// Arrange
		Car car = new Car("1", "123ABC", "Toyota", "Corolla", 50000);
		when(carRepository.existsById("1")).thenReturn(true);

		// Act
		boolean updated = carService.updateCar(car);

		// Assert
		assertTrue(updated);
		verify(carRepository, times(1)).save(car);
	}

	@Test
	public void testUpdateCar_notFound() {
		// Arrange
		Car car = new Car("575", "123ABC", "Toyota", "Corolla", 50000);
		when(carRepository.existsById("575")).thenReturn(false);

		// Act
		boolean updated = carService.updateCar(car);

		// Assert
		assertFalse(updated);
	}

	// Test for deleteCarById
	@Test
	public void testDeleteCarById() {
		// Arrange
		when(carRepository.existsById("1")).thenReturn(true);

		// Act
		boolean deleted = carService.deleteCarById("1");

		// Assert
		verify(carRepository, times(1)).deleteById("1");
		assertTrue(deleted);
	}

	@Test
	public void testDeleteCarById_notFound() {
		// Arrange
		when(carRepository.existsById("1")).thenReturn(false);

		// Act
		boolean deleted = carService.deleteCarById("1");

		// Assert
		assertFalse(deleted);
	}
	}

