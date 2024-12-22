package ftimo.tourserviceapplication.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourResponse {
    private Long id;
    private CarDto car;
    private DriverDto driver;
    private String name;
    private float price;
}
