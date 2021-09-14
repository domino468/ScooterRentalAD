package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.scooter.ScooterService;
import com.scooterrental.webapp.user.User;
import com.scooterrental.webapp.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class RentalServiceTest {
    @Autowired
    private RentalService rentalService;
    @Autowired
    private UserService userService;
    @Autowired
    private ScooterService scooterService;

    @Test
    void shouldAddRental() {
        //given
        String registrationNr = "new RegistrationNr";
        String userNumber = "new userNumber";
        thereIsScooter(registrationNr);
        thereIsUser(userNumber);

        //when
        rentalService.create(registrationNr,userNumber);
        //then
        List<Rental> runningRentals = rentalService.findRunningRentals();
        assertThat(runningRentals.size()).isEqualTo(1);

    }

    private void thereIsUser(String userNumber) {
        User user = new User();
        user.setUserNumber(userNumber);
        user.setFirstName("adam");
        user.setLastName("dominik");
         userService.create(user);
    }

    private Scooter thereIsScooter(String registrationNr) {
        Scooter scooter = new Scooter();
        scooter.setConstructionYear(2021);
        scooter.setMileage(1);
        scooter.setRegistrationNr(registrationNr);
        scooter.setModel("222");
        return  scooterService.createScooter(scooter);

    }
}
