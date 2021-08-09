package com.scooterrental.webapp.user;

import com.scooterrental.webapp.scooter.ScooterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/all")
    ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allScooters = userService.findAllUsers();
        return new ResponseEntity<>(allScooters, HttpStatus.OK);
    }

    @PostMapping("/")
    ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO userDTO) {
        UserDTO add = userService.add(userDTO);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/")
    ResponseEntity<UserDTO> updatedUser(@RequestBody UserDTO userDTO) {
        UserDTO update = userService.update(userDTO);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{mail}")
    ResponseEntity<?> deleteUser(@PathVariable("mail") String mail) {
        userService.deleteUserByMail(mail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
