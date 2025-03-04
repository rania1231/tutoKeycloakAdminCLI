package hamdi.rania.tutokeycloakadmincli.service;

import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.dto.UserRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.entities.UserProfile;
import hamdi.rania.tutokeycloakadmincli.repository.UserRepository;
import hamdi.rania.tutokeycloakadmincli.service.keycloak.KeycloakUserService;
import hamdi.rania.tutokeycloakadmincli.service.profile.UserProfileService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private UserProfileService userProfileService;
    private KeycloakUserService keycloakUserService;

    public UserServiceImpl(UserProfileService userProfileService, KeycloakUserService keycloakUserService) {
        this.userProfileService = userProfileService;
        this.keycloakUserService = keycloakUserService;
    }

    @Override
    public UserProfile getUserProfileById(UUID userId) throws Exception {

        return userProfileService.getUserProfileById(userId);
    }

    @Override
    public UserProfile createUserProfile(UserProfileRegistrationRecord user) throws Exception {
        System.out.println("We will start creating the user profile");
        UserRepresentation userRepresentation=keycloakUserService.createUser(user);
        System.out.println("user created by keycloak= "+userRepresentation);
        UserProfile userProfile=userProfileService.createUserProfile(user);
        System.out.println("user created by our service"+userProfile.toString());
        return userProfile;
    }

    @Override
    public void deleteUserProfileById(UUID userId) throws Exception {
        keycloakUserService.deleteUserById(userId.toString());
        userProfileService.deleteUserProfileById(userId);
    }

    @Override
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfiles();
    }
}
