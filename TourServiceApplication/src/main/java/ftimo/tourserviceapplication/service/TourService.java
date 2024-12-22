package ftimo.tourserviceapplication.service;

import ftimo.tourserviceapplication.dto.DriverDto;
import ftimo.tourserviceapplication.dto.TourResponse;
import ftimo.tourserviceapplication.model.Tour;
import ftimo.tourserviceapplication.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class TourService{
    private final TourRepository tourRepository;
    private final WebClient webClient;

    @Value("${driverservice.baseurl}")
    private String driverServiceBaseUrl;


    public List<Tour> getAllTours() {
        List<Tour> tours = tourRepository.findAll();
        List<TourResponse> rtours = new ArrayList<TourResponse>();

        for (Tour e : tours) {
            TourResponse rtour = new TourResponse();
            rtour.setName(e.getName());
            rtour.setPrice(e.getPrice());
            DriverDto[] drivers = webClient.get()
                    .uri("http://" + driverServiceBaseUrl + "/api/driver",
                            uriBuilder ->  uriBuilder.queryParam("id", e.getDriverId()).build())
                    .retrieve()
                    .bodyToMono(DriverDto[].class)
                    .block();

            System.out.println(drivers[0].getFirstName());


        }

        //return drivers.stream().map(order -> new OrderResponse(order.getOrderNumber(),mapToOrderLineItemsDto(order.getOrderLineItemsList()))).collect(Collectors.toList());
        return tours;
    }

}