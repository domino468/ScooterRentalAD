package com.scooterrental.webapp.user;

import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.scooter.ScooterDTO;
import com.scooterrental.webapp.scooter.ScooterNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User add(UserDTO userDTO) {
        Optional<User> userByMail = userRepository
                .findUserByMail(userDTO.getMail());

        User user = userRepository.save(convertDTOToUser(userDTO));
        return convertDTOToUser(userDTO);
    }

    List<UserDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertUserToDTO)
                .collect(Collectors.toList());
    }



    void deleteUserByMail(String mail) {
        userRepository.deleteUserByMail(mail);
    }

    private UserDTO convertUserToDTO(User user) {
        return new UserDTO(
                user.getName(),
                user.getLastName(),
                user.getMail(),
                user.getPhoneNumber()
        );
    }

    private User convertDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setMail(userDTO.getMail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;

    }
}
