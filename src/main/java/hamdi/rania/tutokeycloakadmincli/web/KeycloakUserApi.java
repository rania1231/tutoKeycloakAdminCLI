package hamdi.rania.tutokeycloakadmincli.web;

import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import lombok.AllArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.*;
import hamdi.rania.tutokeycloakadmincli.dto.UserRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.service.keycloak.KeycloakUserService;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/kusers")
@AllArgsConstructor
public class KeycloakUserApi {

    private final KeycloakUserService keycloakUserService;


    @PostMapping
    public UserRepresentation createUser(@RequestBody UserProfileRegistrationRecord user) {
        return keycloakUserService.createUser(user);
    }
    //We use principal here to be sure that he can only get his data
    @GetMapping
    public UserRepresentation getUser(Principal principal) {
        return keycloakUserService.getUserById(principal.getName());
    }
    //We use principal here to be sure that he can only delete his profile
    @DeleteMapping()
    public void deleteUser(Principal principal) {
        keycloakUserService.deleteUserById(principal.getName());
    }

}
