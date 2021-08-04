package com.scooterrental.webapp.scooter;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScooterService {
    private ScooterRepository scooterRepository;

    public ScooterService(ScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    public ScooterDTO add(ScooterDTO scooterDTO) {
        Optional<Scooter> scooterByMark = scooterRepository
                .findScooterByMark(scooterDTO);

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
        Optional<Scooter> optionalScooter = scooterRepository
                .updateScooterByRange((updatedScooter.getRange()));
        Scooter existingScooter = optionalScooter.orElseThrow(ScooterNotFoundException::new);
        existingScooter.update(convertDTOToScooter(updatedScooter));
        scooterRepository.save(existingScooter);
        return convertScooterToDTO(existingScooter);
    }

    void deleteScooterByMark(String markOfScooter) {
        scooterRepository.deleteScooterByMark(markOfScooter);
    }

    private ScooterDTO convertScooterToDTO(Scooter scooter) {
        return new ScooterDTO(
                scooter.getMarkOfScooter(),
                scooter.getRange(),
                scooter.getBatteryCondition()

        );
    }

    private Scooter convertDTOToScooter(ScooterDTO scooterDTO) {
        Scooter scooter = new Scooter();
        scooter.setMarkOfScooter(scooterDTO.getMarkOfScooter());
        scooter.setRange(scooterDTO.getRange());
        scooter.setBatteryCondition(scooterDTO.getBatteryCondition());
        return scooter;

    }
}
