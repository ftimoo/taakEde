package ftimo.tourserviceapplication.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DriverDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String licenceNumber;
    private String profilePicture;
}
