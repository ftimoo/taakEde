package ftimo.tourserviceapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CarDto {
    private String id;
    private String plate;
    private String model;
    private String brand;
    private BigDecimal odometer;
}
