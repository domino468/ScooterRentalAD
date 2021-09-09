package com.scooterrental.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public void create(User user) {
        if (userRepository.existsById(user.getUserNumber())) {
        }
        userRepository.save(user);
    }

    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }
}
