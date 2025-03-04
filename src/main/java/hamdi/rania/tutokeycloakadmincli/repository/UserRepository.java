package hamdi.rania.tutokeycloakadmincli.repository;

import hamdi.rania.tutokeycloakadmincli.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, UUID> {


    Optional<UserProfile> findByEmail(String email);
}
