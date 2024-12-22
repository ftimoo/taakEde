package ftimo.tourserviceapplication.service;

import ftimo.tourserviceapplication.dto.CarDto;
import ftimo.tourserviceapplication.dto.DriverDto;
import ftimo.tourserviceapplication.dto.TourResponse;
import ftimo.tourserviceapplication.model.Tour;
import ftimo.tourserviceapplication.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TourService{
    private final TourRepository tourRepository;
    private final WebClient webClient;

    @Value("${driverservice.baseurl}")
    private String driverServiceBaseUrl;

    @Value("${carservice.baseurl}")
    private String carServiceBaseUrl;

    public TourResponse createTourResponse(Tour tour) {
        String carId = tour.getCarId();
        Long driverId = tour.getDriverId();
        Long tourId = tour.getId();
        String name = tour.getName();
        float price = tour.getPrice();



        // Fetch car details
        CarDto car = fetchCarById(carId);

        // Fetch driver details
        DriverDto driver = fetchDriverById(driverId);

        // Create and return TourResponse
        TourResponse tourResponse = new TourResponse();
        tourResponse.setId(tourId);
        tourResponse.setCar(car);
        tourResponse.setDriver(driver);
        tourResponse.setName(name);
        tourResponse.setPrice(price);

        return tourResponse;
    }
    public List<TourResponse> getAllTours(){
        List<Tour> tours = tourRepository.findAll();

        return tours.stream()
                .map(this::createTourResponse)
                .collect(Collectors.toList());
    }
    private CarDto fetchCarById(String carId) {
        String url = String.format("%s/api/car/%s", carServiceBaseUrl, carId);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(CarDto.class)
                .block();
    }
    private DriverDto fetchDriverById(Long driverId) {
        String url = String.format("%s/api/driver/%d", driverServiceBaseUrl , driverId);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(DriverDto.class)
                .block();
    }



}