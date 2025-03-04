package hamdi.rania.tutokeycloakadmincli.mapper;

import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.entities.UserProfile;

import org.springframework.stereotype.Service;

@Service
public class UserProfileMapper {



    public UserProfileRegistrationRecord from(UserProfile userProfile) {


        return new UserProfileRegistrationRecord(userProfile.getUsername(), userProfile.getEmail(), userProfile.getFirstName(), userProfile.getLastName(), userProfile.getPassword());
    }
    public UserProfile from(UserProfileRegistrationRecord userProfileRegistrationRecord) {
        return UserProfile.builder()
                .username(userProfileRegistrationRecord.username())
                .email(userProfileRegistrationRecord.email())
                .firstName(userProfileRegistrationRecord.firstName())
                .lastName(userProfileRegistrationRecord.lastName())
                .password(userProfileRegistrationRecord.password())
                .build();
    }

}
