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

    public TourResponse createTourResponse(Long tourId, Long carId, Long driverId, String name, float price) {
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
    private CarDto fetchCarById(Long carId) {
        String url = String.format("%s/api/car/%d", carServiceBaseUrl, carId);
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