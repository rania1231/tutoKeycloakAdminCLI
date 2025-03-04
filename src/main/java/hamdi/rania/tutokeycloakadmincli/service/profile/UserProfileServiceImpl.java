package hamdi.rania.tutokeycloakadmincli.service.profile;


import hamdi.rania.tutokeycloakadmincli.dto.UserProfileRegistrationRecord;
import hamdi.rania.tutokeycloakadmincli.entities.UserProfile;
import hamdi.rania.tutokeycloakadmincli.exception.EmailAlreadyExistsException;
import hamdi.rania.tutokeycloakadmincli.exception.UserIdNotFound;
import hamdi.rania.tutokeycloakadmincli.mapper.UserProfileMapper;
import hamdi.rania.tutokeycloakadmincli.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private final UserRepository userRepository;
    private final UserProfileMapper userProfileMapper;

    public UserProfileServiceImpl(UserRepository userRepository, UserProfileMapper userProfileMapper) {
        this.userRepository = userRepository;
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public UserProfile getUserProfileById(UUID userId) throws Exception{
        Optional<UserProfile> userProfile= userRepository.findById(userId);
        if(userProfile.isPresent()){
            return userProfile.get();
        }
        else{
            throw new UserIdNotFound("THis user does not exist");
        }

    }

    @Override
    public UserProfile createUserProfile(UserProfileRegistrationRecord user) throws Exception {
        if (userRepository.findByEmail(user.email()).isPresent()) {
            throw new EmailAlreadyExistsException("This email is already registered, try another one");
        }
        UserProfile userProfile=userProfileMapper.from(user);
        System.out.println("THis user mapped =" + userProfile);
        return userRepository.save(userProfile);
    }



    @Override
    public void deleteUserProfileById(UUID userId) throws Exception{
        Optional<UserProfile> userProfile= userRepository.findById(userId);
        if(userProfile.isPresent()){
            userRepository.delete(userProfile.get());
        }
        else{
            throw new UserIdNotFound("This user does not exist");
        }

    }

    @Override
    public List<UserProfile> getUserProfiles() {
        return userRepository.findAll();
    }


}
