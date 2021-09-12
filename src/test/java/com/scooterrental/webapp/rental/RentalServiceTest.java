package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

//@SpringBootTest
//@Transactional
//public class RentalServiceTest {
//    @Autowired
//    private RentalService rentalService;
//
//    @Test
//    //given
//    void shouldAddRental(){
//        Rental rental = new Rental();
//        rental.setRentalDate(LocalDate.parse("22-22-2021"));
//        rental.setReturnDate(LocalDate.parse("23-22-2021"));
//        rental.setKm(100);
//        rental.setScooter();
//    }
//}
