package ftimo.tourserviceapplication;

import ftimo.tourserviceapplication.dto.CarDto;
import ftimo.tourserviceapplication.dto.DriverDto;
import ftimo.tourserviceapplication.dto.TourResponse;
import ftimo.tourserviceapplication.model.Tour;
import ftimo.tourserviceapplication.repository.TourRepository;
import ftimo.tourserviceapplication.service.TourService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TourServiceTest {

    @Mock
    private TourRepository tourRepository;

    @Mock
    private WebClient webClient;

    @InjectMocks
    private TourService tourService;
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;


    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(tourService, "carServiceBaseUrl", "http://localhost:8080");
        ReflectionTestUtils.setField(tourService, "driverServiceBaseUrl", "http://localhost:8082");
    }

    @Test
    public void testGetAllTours() {


    }

    @Test
    public void testcreateTourResponse() {
        // Given


    }



}
