package hamdi.rania.tutokeycloakadmincli.web;

import lombok.AllArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.*;
import hamdi.rania.tutokeycloakadmincli.dto.UserRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.service.keycloak.KeycloakUserService;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
@AllArgsConstructor
public class KeycloakUserApi {

    private final KeycloakUserService keycloakUserService;


    @PostMapping
    public UserRegistrationRecord createUser(@RequestBody UserRegistrationRecord user) {
        return keycloakUserService.createUser(user);
    }

    @GetMapping
    public UserRepresentation getUser(Principal principal) {
        return keycloakUserService.getUserById(principal.getName());
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        keycloakUserService.deleteUserById(userId);
    }
}
