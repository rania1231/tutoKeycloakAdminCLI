package hamdi.rania.tutokeycloakadmincli.dto;

import jakarta.persistence.Column;

import java.util.UUID;

public class UserProfileDTO {
    private UUID userId;
    private  String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
