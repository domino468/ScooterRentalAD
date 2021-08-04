package com.scooterrental.webapp.user;

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

    UserDTO add(UserDTO userDTO) {
        Optional<User> userByMail = userRepository
                .findUserByMail(userDTO.getMail());

        User user = userRepository.save(convertDTOToUser(userDTO));
        return convertUserToDTO(user);
    }

    List<UserDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertUserToDTO)
                .collect(Collectors.toList());
    }

    UserDTO update( UserDTO updatedUser) {
        Optional<User> existingUser = userRepository
                .findUserByMail(updatedUser.getMail());
        User user = existingUser.orElseThrow(UserNotFoundException::new);
        user.update(convertDTOToUser(updatedUser));
        userRepository.save(user);
        return convertUserToDTO(user);
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
