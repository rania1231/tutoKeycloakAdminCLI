package hamdi.rania.tutokeycloakadmincli.service.keycloak;

import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import org.keycloak.representations.idm.UserRepresentation;
import hamdi.rania.tutokeycloakadmincli.dto.UserRegistrationRecord;

import java.util.List;

public interface KeycloakUserService {
    UserRepresentation createUser(UserProfileRegistrationRecord user);
    UserRepresentation getUserById(String userId);
    void deleteUserById(String userId);
    List<UserRepresentation>getUsers();
}
