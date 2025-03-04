package hamdi.rania.tutokeycloakadmincli.service.profile;


import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.entities.UserProfile;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;
import java.util.UUID;

public interface UserProfileService {
    UserProfile getUserProfileById(UUID userId)throws Exception;
    UserProfile createUserProfile(UserProfileRegistrationRecord user) throws Exception;
    void deleteUserProfileById(UUID userId)throws Exception;
    List<UserProfile> getUserProfiles( );//UserProfile to be replaced by UserProfileDTO

}
