package hamdi.rania.tutokeycloakadmincli.service.keycloak;

import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import hamdi.rania.tutokeycloakadmincli.dto.UserRegistrationRecord;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class KeycloakUserServiceImpl implements KeycloakUserService {
    private final Keycloak keycloak;

    public KeycloakUserServiceImpl(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    @Override
    public UserRepresentation createUser(UserProfileRegistrationRecord userRegistrationRecord) {
        //assigning the values of our user to userRepresentation
         UserRepresentation userRepresentation = new UserRepresentation();
         userRepresentation.setEnabled(true);
         userRepresentation.setUsername(userRegistrationRecord.username());
         userRepresentation.setEmail(userRegistrationRecord.email());
         userRepresentation.setFirstName(userRegistrationRecord.firstName());
         userRepresentation.setLastName(userRegistrationRecord.lastName());
         userRepresentation.setEmailVerified(true);

        //Creating a CredentialRepresentation (password in our case) to be given to our user
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(userRegistrationRecord.password());
        credentialRepresentation.setTemporary(false);

        //Assigning the credentialRepresentation created to our user
        List<CredentialRepresentation> list = new ArrayList<>();
        list.add(credentialRepresentation);
        userRepresentation.setCredentials(list);

        //Calling the end point of keycloak to create a user and get the response returned

        UsersResource usersResource = getUsersResource();
        Response response=usersResource.create(userRepresentation);

       if(response.getStatus() == Response.Status.CREATED.getStatusCode()){
           return userRepresentation;
       }
//       response.readEntity()


        return null;
    }

    private UsersResource getUsersResource() {
        RealmResource realm=keycloak.realm("ecom-realm");
        return realm.users();
    }

    @Override
    public UserRepresentation getUserById(String userId) {

       return getUsersResource().get(userId).toRepresentation();
    }

    @Override
    public void deleteUserById(String userId) {
        getUsersResource().delete(userId);
    }

    @Override
    public List<UserRepresentation> getUsers() {
        return getUsersResource().list();
    }

}
