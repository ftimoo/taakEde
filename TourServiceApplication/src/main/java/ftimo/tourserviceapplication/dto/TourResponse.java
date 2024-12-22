package ftimo.tourserviceapplication.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourResponse {
    private Long id;
    private CarDto car;
    @OneToOne(cascade = CascadeType.DETACH)
    private DriverDto driver;
    private String name;
    private float price;
}
