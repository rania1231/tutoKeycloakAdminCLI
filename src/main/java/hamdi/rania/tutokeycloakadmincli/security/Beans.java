package hamdi.rania.tutokeycloakadmincli.security;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // THis class will create a bean
public class Beans {
    @Bean
    public Keycloak keycloak(){
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("ecom-realm")
                .grantType("client_credentials")
                .clientId("admin-cli")
                .clientSecret("5sKX7KEPyiQ3Jt74i2JIvKpWp0hGok6Q")
                .build();
    }
}
