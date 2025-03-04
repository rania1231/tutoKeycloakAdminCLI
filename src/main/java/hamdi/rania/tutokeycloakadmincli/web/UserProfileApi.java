package hamdi.rania.tutokeycloakadmincli.web;

import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.entities.UserProfile;
import hamdi.rania.tutokeycloakadmincli.service.profile.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/profiles")
@AllArgsConstructor
public class UserProfileApi {
    private UserProfileService userProfileService;
    @GetMapping()
    public List<UserProfile> getUsersProfile() {
        return userProfileService.getUserProfiles();
    }

    @GetMapping("/{userId}")
    public UserProfile getUserProfile(@PathVariable UUID userId) throws Exception {
        return userProfileService.getUserProfileById( userId);
    }
    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfileRegistrationRecord user) throws Exception {
        return userProfileService.createUserProfile(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserProfile(@PathVariable UUID userId) throws Exception {
        userProfileService.deleteUserProfileById(userId);
    }

}
