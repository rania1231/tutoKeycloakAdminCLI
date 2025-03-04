package hamdi.rania.tutokeycloakadmincli.service;

import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.entities.UserProfile;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserProfile getUserProfileById(UUID userId)throws Exception;
    UserProfile createUserProfile(UserProfileRegistrationRecord user) throws Exception;
    void deleteUserProfileById(UUID userId)throws Exception;
    List<UserProfile>getUserProfiles();
}
