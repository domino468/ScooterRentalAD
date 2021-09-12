package com.scooterrental.webapp.scooter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ScooterServiceTest {
    @Autowired
    private ScooterService scooterService;

    @Test
    void shouldAddScooter() {
        //given
        Scooter scooter = new Scooter();
        scooter.setConstructionYear(2021);
        scooter.setMileage(1);
        scooter.setRegistrationNr("1");
        scooter.setModel("222");
        //when
        scooterService.createScooter(scooter);
        //then
        Optional<Scooter> byRegistrationNr = scooterService.findByRegistrationNr("1");
        assertThat(byRegistrationNr).isNotEmpty();

    }

    @Test
    void shouldShowAllScooters() {
        //given
        Scooter scooter = new Scooter();
        scooter.setConstructionYear(2021);
        scooter.setMileage(1);
        scooter.setRegistrationNr("1");
        scooter.setModel("222");
        scooterService.createScooter(scooter);
        //when
        List<Scooter> allScooters = scooterService.findAllScooters();
        //then
        assertThat(allScooters).contains(scooter);
    }

    @Test
    void shouldDeleteScooter() {
        //given
        Scooter scooter = new Scooter();
        scooter.setConstructionYear(2021);
        scooter.setMileage(1);
        scooter.setRegistrationNr("1");
        scooter.setModel("222");
        //when
        scooterService.deleteByRegistrationNr(scooter.getRegistrationNr());
        //then
        List<Scooter> allScooters = scooterService.findAllScooters();
        assertThat(allScooters.isEmpty());
    }
    //is it good ?
    @Test
    void shouldFindScooterByLocation(){
        //given
        Scooter scooter = new Scooter();
        scooter.setConstructionYear(2021);
        scooter.setMileage(1);
        scooter.setRegistrationNr("1");
        scooter.setModel("222");
        scooter.setLocation("140NW");
        scooterService.createScooter(scooter);
        //when
        List<Scooter> findByLocation = scooterService.findByLocation(scooter.getLocation());
        //then
        assertThat(findByLocation).contains(scooter);
    }
//    @Test
//    void shouldCheckIfScooterIsUpdated() {
//        //given
//        Scooter scooter = new Scooter();
//        scooter.setConstructionYear(2020);
//        scooter.setMileage(1);
//        scooter.setRegistrationNr("1");
//        scooter.setModel("222");
//        Scooter newScooter = new Scooter();
//        scooter.setConstructionYear(2021);
//        scooter.setMileage(1);
//        scooter.setRegistrationNr("");
//        scooter.setModel("232");
//        scooterService.createScooter(scooter);
//        //when
//        scooterService.update(scooter.getRegistrationNr(), newScooter);
//        //then
//        List<Scooter> allScooters = scooterService.findAllScooters();
//        assertThat(allScooters).containsExactly(newScooter);
//    }

}