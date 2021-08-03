package com.scooterrental.webapp.scooter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ScooterServiceTest {
    @Autowired
    private ScooterService scooterService;

    @Test
    public void shouldAddScooter(){
        //given
        ScooterDTO scooter = new ScooterDTO("444","444");
        //when
        scooterService.add(scooter);
        //then
        assertThat(scooterService.findAllScooters()).containsExactlyInAnyOrder(scooter);
    }

}