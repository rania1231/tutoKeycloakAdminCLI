package hamdi.rania.tutokeycloakadmincli.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private  String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;

}