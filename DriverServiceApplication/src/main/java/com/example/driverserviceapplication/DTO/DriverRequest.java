package com.example.driverserviceapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequest {
    private String firstName;
    private String lastName;
    private String licenceNumber;
    private String profilePicture;
}
