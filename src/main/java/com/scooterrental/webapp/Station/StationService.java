package com.scooterrental.webapp.Station;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    private StationRepository stationRepository;

    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    public boolean existsById(String id) {
        return stationRepository.existsById(Integer.valueOf(id));
    }
}
