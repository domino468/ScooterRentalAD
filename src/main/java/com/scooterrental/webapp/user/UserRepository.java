package com.scooterrental.webapp.user;

import com.scooterrental.webapp.scooter.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByMail(String mail);

    Optional<User> updateUserMail(String mail);

    void deleteUserByMail(String mail);
}
