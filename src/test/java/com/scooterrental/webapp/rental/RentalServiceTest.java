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
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        Integer km = 1;
        double startLatitude = 69.7;
        double startLongitude = 87.4;
        thereIsScooter(registrationNr);
        thereIsUser(userNumber);
        thereIsStartLatitude(startLatitude);
        thereIsStartLongitude(startLongitude);
        //when
        rentalService.create(registrationNr,userNumber,km, startLatitude, startLongitude);
        //then
        List<Rental> runningRentals = rentalService.findRunningRentals();
        assertThat(runningRentals.size()).isEqualTo(1);

    }
    @Test
    void shouldFinishRental(){
        //given
        String registrationNr = "new RegistrationNr";
        String userNumber = "new userNumber";
        Integer km = 1;
        double startLatitude = 69.7;
        double startLongitude = 87.4;
        thereIsScooter(registrationNr);
        thereIsUser(userNumber);
        thereIsStartLatitude(startLatitude);
        thereIsStartLongitude(startLongitude);
        //when
        Rental rental = rentalService.create(registrationNr, userNumber, km, startLatitude, startLongitude);
        rentalService.finish(rental,69.7,87.4, LocalDateTime.now());
        //then
        List<Rental> runningRentals = rentalService.findRunningRentals();
        assertThat(runningRentals).isEmpty();
    }
    @Test
    void shouldNotFinishAlreadyFinishedRental(){
        //given
        String registrationNr = "new RegistrationNr";
        String userNumber = "new userNumber";
        Integer km = 1;
        double startLatitude = 69.7;
        double startLongitude = 87.4;
        thereIsScooter(registrationNr);
        thereIsUser(userNumber);
        thereIsStartLatitude(startLatitude);
        thereIsStartLongitude(startLongitude);
        //when
        Rental rental = rentalService.create(registrationNr, userNumber, km, startLatitude, startLongitude);
        rentalService.finish(rental,69.7,87.4, LocalDateTime.now());
        //then
        assertThrows(RentalAlreadyFinished.class,() -> rentalService.finish(rental,69.7,87.4, LocalDateTime.now()));
    }

    private void thereIsStartLatitude(double startLatitude){

    }
    private void thereIsStartLongitude(double startLongitude){

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
