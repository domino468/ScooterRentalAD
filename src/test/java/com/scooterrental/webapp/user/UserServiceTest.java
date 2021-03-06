package com.scooterrental.webapp.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void shouldAddUser() {
        //given
        User user = new User();
        user.setUserNumber("1");
        user.setFirstName("adam");
        user.setLastName("dominik");
        //when
        userService.create(user);
        //then
        List<User> byFirstName = userService.findByFirstName("adam");
        assertThat(byFirstName).isNotEmpty();

    }

    @Test
    void shouldShowAllUsers() {
        //given
        User user = new User();
        user.setUserNumber("1");
        user.setFirstName("adam");
        user.setLastName("dominik");
        userService.create(user);
        //when
        List<User> showALlUsers = userService.findAllUsers();
        //then
        assertThat(showALlUsers).contains(user);
    }

    @Test
    void shouldDeleteUser() {
        //given
        User user = new User();
        user.setUserNumber("1");
        user.setFirstName("adam");
        user.setLastName("dominik");
        userService.create(user);
        //when
        userService.deleteByFirstName(user.getFirstName());
        //then
        List<User> allUsers = userService.findAllUsers();
        assertThat(allUsers).isEmpty();
    }
}
