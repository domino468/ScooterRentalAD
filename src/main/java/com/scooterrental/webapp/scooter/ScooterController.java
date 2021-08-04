package com.scooterrental.webapp.scooter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scooter")
@CrossOrigin(origins = "http://localhost:4200")
public class ScooterController {
    private final ScooterService scooterService;

    public ScooterController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @GetMapping("/all")
    ResponseEntity<List<ScooterDTO>> getAllScooters() {
        List<ScooterDTO> allScooters = scooterService.findAllScooters();
        return new ResponseEntity<>(allScooters, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<ScooterDTO> addNewScooter(@RequestBody ScooterDTO scooterDTO) {
        ScooterDTO add = scooterService.add(scooterDTO);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<ScooterDTO> updatedScooter(@RequestBody ScooterDTO scooterDTO) {
        ScooterDTO update = scooterService.update(scooterDTO);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{mark}")
    ResponseEntity<?> deleteScooter(@PathVariable("mark") String markOfScooter) {
        scooterService.deleteScooterByMark(markOfScooter);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
