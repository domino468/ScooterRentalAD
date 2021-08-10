package com.scooterrental.webapp.scooter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ScooterServiceTest {
    @Autowired
    private ScooterService scooterService;

    @Test
    public void shouldAddScooter(){
        //given
        ScooterDTO scooter = new ScooterDTO("", "444",444,"");
        //when
        scooterService.add(scooter);
        //then
        assertThat(scooterService.findAllScooters()).containsExactlyInAnyOrder(scooter);
    }
    @Test
    public void shouldShowAllScooters(){
        //given
        ScooterDTO scooters = new ScooterDTO("", "",1,"");
        scooterService.add(scooters);
        //when
        List<ScooterDTO> allScooters = scooterService.findAllScooters();
        //then
        assertThat(scooterService.findAllScooters()).contains(scooters);
    }
    @Test
    public void shouldDeleteScooter() {
        //given
        ScooterDTO scooter = new ScooterDTO("", "", "");
        scooterService.add(scooter);
        //when
        scooterService.deleteScooterByMark(scooter.getMarkOfScooter());
        //then
        List<ScooterDTO> allScooters = scooterService.findAllScooters();
        assertThat(allScooters).isEmpty();
    }
    //czemu nie chce dzialac?
//    @Test
//    public void shouldCheckIfScooterIsUpdated() {
//        //given
//        ScooterDTO scooter = new ScooterDTO("1", "1", "1");
//        ScooterDTO newScooter = new ScooterDTO("2", "1", "1");
//        scooterService.add(scooter);
//        //when
//        scooterService.update(scooter.getMarkOfScooter(newScooter.getMarkOfScooter(scooter)));
//        //then
//        List<ScooterDTO> allScooters = scooterService.findAllScooters();
//        assertThat(allScooters).containsExactly(newScooter);
//    }
//
}