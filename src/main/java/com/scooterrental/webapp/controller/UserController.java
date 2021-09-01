package com.scooterrental.webapp.controller;

import com.scooterrental.webapp.Station.SelectedStation;
import com.scooterrental.webapp.Station.StationService;
import com.scooterrental.webapp.scooter.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class PublicController {

    @Autowired
    private ScooterService scooterService;

    @Autowired
    private StationService stationService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("selectedStationBean", new SelectedStation());
        model.addAttribute("stations", stationService.findAll());
        return "fragments/search-rentals";
    }

    @PostMapping
    public String processForm(Model model,
                              @Valid @ModelAttribute("selectedStationBean") SelectedStation selectedStationBean,
                              BindingResult bindingResult) {
        model.addAttribute("stations", stationService.findAll());
        model.addAttribute("cars", bindingResult.hasErrors() ? null : scooterService.findByStation(selectedStationBean.getStation()));
        return "fragments/search-rentals";
    }
}
