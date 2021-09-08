package com.scooterrental.webapp.scooter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ScooterServiceTest {
    @Autowired
    private ScooterService scooterService;

    @Test
    void shouldAddScooter(){
        //given
        Scooter scooter = new Scooter();
        scooter.setConstructionYear(2021);
        scooter.setMileage(1);
        scooter.setRegistrationNr("1");
        scooter.setModel("222");
        //when
        scooterService.create(scooter);
        //then
        List<Scooter> byRegistrationNr = scooterService.findByRegistrationNr("1");
        assertThat(byRegistrationNr).isNotEmpty();

    }
    @Test
    void shouldShowAllScooters(){
        //given
        Scooter scooter = new Scooter();
        scooterService.create(scooter);
        //when
        List<Scooter> allScooters = scooterService.showAllScooters();
        //then
        assertThat(allScooters).contains(scooter);
    }

}