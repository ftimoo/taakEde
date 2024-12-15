package ftimo.tourserviceapplication.service;

import ftimo.tourserviceapplication.model.Tour;
import ftimo.tourserviceapplication.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TourService{
    private final TourRepository tourRepository;


    public List<Tour> getAllTours() {
        List<Tour> tours = tourRepository.findAll();

        //return drivers.stream().map(order -> new OrderResponse(order.getOrderNumber(),mapToOrderLineItemsDto(order.getOrderLineItemsList()))).collect(Collectors.toList());
        return tours;
    }

}