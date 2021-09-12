package com.scooterrental.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<User> findAllUsers() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> findByFirstName(String firstName) {

        return userRepository.findByFirstName(firstName);
    }

    void deleteByFirstName(String firstName){userRepository.deleteByFirstName(firstName);}
}
