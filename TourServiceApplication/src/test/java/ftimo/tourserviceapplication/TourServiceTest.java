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

        TourResponse tourResponse = new TourResponse();
        tourResponse.setPrice(23.23f);
        tourResponse.setName("testdrive Mol");
        tourResponse.setId(1L);

        CarDto carDto = new CarDto();
        carDto.setId("123");
        carDto.setPlate("ABC-123");
        carDto.setOdometer(133113);
        carDto.setBrand("Mercedes");
        carDto.setModel("G-klasse");

        // When

        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString(),  any(Function.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(CarDto[].class)).thenReturn(Mono.just(new CarDto[]{carDto}));

        // Then
        List<TourResponse> tourResponse1 = tourService.getAllTours();

        assert tourResponse.getId().equals(1L);
        assert tourResponse.getName().equals("Test Tour");
        assert tourResponse.getCar().getModel().equals("Test Car");
        assert tourResponse.getDriver().getFirstName().equals("Test Driver");
        assert tourResponse.getPrice() == 100.0f;



        // Verify the interactions
        verify(webClient, times(1)).get();
        verify(webClient.get().uri(anyString()).retrieve(), times(2)).bodyToMono(CarDto.class);
    }

    @Test
    public void testcreateTourResponse() {
        // Given
        Tour tour = new Tour();
        tour.setId(1L);
        tour.setName("test");
        tour.setCarId("1234");
        tour.setDriverId(1L);
        tour.setPrice(2.34f);

        //act
        TourResponse tourResponse = tourService.createTourResponse(tour);
        when(webClient.get()).thenReturn(null);
        //assert
        assertEquals(tourResponse.getPrice(), 2.34f);
        assertEquals(tourResponse.getDriver(), null);
        assertEquals(tourResponse.getCar(), null);
        assertEquals(tourResponse.getName(), "test");


    }



}
