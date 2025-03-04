package hamdi.rania.tutokeycloakadmincli.web;

import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.dto.UserRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.entities.UserProfile;
import hamdi.rania.tutokeycloakadmincli.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
@AllArgsConstructor
public class UserApi {
    private UserService userService;
    @GetMapping
    public List<UserProfile> getUserProfiles() {
        return userService.getUserProfiles();
    }

    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfileRegistrationRecord user) throws Exception {
        return userService.createUserProfile(user);
    }

    @GetMapping("/{userId}")
    public UserProfile getUserProfileById(@PathVariable UUID userId) throws Exception {
        return userService.getUserProfileById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserProfileById(@PathVariable UUID userId) throws Exception {
        userService.deleteUserProfileById(userId);
    }
}
