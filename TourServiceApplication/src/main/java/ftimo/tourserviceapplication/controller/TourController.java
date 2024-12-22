package ftimo.tourserviceapplication.controller;

import ftimo.tourserviceapplication.dto.TourResponse;
import ftimo.tourserviceapplication.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TourResponse> getAllOrders() {
        return tourService.getAllTours();
    }
}
