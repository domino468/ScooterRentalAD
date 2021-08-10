package com.scooterrental.webapp.scooter;

import com.scooterrental.webapp.user.UserDTO;
import com.scooterrental.webapp.user.UserService;
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
        UserDTO user = new UserDTO("av", "va","avava","123456789");
        //when
        userService.add(user);
        //then
        assertThat(userService.findAllUsers()).containsExactlyInAnyOrder(user);
    }
    @Test
    void shouldShowAllUsers() {
        //given
        UserDTO users = new UserDTO("", "", "","");
        userService.add(users);
        //when
        List<UserDTO> allUsers = userService.findAllUsers();
        //then
        assertThat(allUsers).contains(users);
    }
}
