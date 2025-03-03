package hamdi.rania.tutokeycloakadmincli.service.keycloak;

import org.keycloak.representations.idm.UserRepresentation;
import hamdi.rania.tutokeycloakadmincli.dto.UserRegistrationRecord;

public interface KeycloakUserService {
    UserRegistrationRecord createUser(UserRegistrationRecord user);
    UserRepresentation getUserById(String userId);
    void deleteUserById(String userId);
}
