package com.scooterrental.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public void create(User user) {

        userRepository.save(user);
    }


    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
