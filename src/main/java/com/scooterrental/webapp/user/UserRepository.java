package com.scooterrental.webapp.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);

    Optional<User> findUserByUserNumber(String userNumber);

    List<User> deleteByFirstName(String firstName);
}
