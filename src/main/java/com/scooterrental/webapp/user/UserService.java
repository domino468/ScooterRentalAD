package com.scooterrental.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<User> findAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> findByFirstName(String firstName) {

        return userRepository.findByFirstName(firstName);
    }

    void deleteByFirstName(String firstName){userRepository.deleteByFirstName(firstName);}

    public User findByUserNumber(String userNumber){
        Optional<User> user = userRepository.findUserByUserNumber(userNumber);

        return  user.orElseThrow(() ->  new RuntimeException("Could not Find User by user number!"));
    }
}
