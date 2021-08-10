package com.scooterrental.webapp.scooter;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScooterService {
    private final ScooterRepository scooterRepository;

    public ScooterService(ScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    public ScooterDTO add(ScooterDTO scooterDTO) {
        Scooter scooter = scooterRepository.save(convertDTOToScooter(scooterDTO));
        return convertScooterToDTO(scooter);
    }

    public List<ScooterDTO> findAllScooters() {
        return scooterRepository.findAll()
                .stream()
                .map(this::convertScooterToDTO)
                .collect(Collectors.toList());
    }

    ScooterDTO update(ScooterDTO updatedScooter) {

        Scooter existingScooter = new Scooter();
        existingScooter.update(convertDTOToScooter(updatedScooter));
        scooterRepository.save(existingScooter);
        return convertScooterToDTO(existingScooter);
    }

    void deleteScooterByMark(String markOfScooter) {
        scooterRepository.deleteScooterByMarkOfScooter(markOfScooter);
    }

    private ScooterDTO convertScooterToDTO(Scooter scooter) {
        return new ScooterDTO(
                scooter.getBarcode(),
                scooter.getMarkOfScooter(),
                scooter.getRange(),
                scooter.getBatteryCondition()

        );
    }

    private Scooter convertDTOToScooter(ScooterDTO scooterDTO) {
        Scooter scooter = new Scooter();
        scooter.setBarcode(scooterDTO.getBarcode());
        scooter.setMarkOfScooter(scooterDTO.getMarkOfScooter());
        scooter.setRange(scooterDTO.getRange());
        scooter.setBatteryCondition(scooterDTO.getBatteryCondition());
        return scooter;

    }
}
