package com.scooterrental.webapp.controller;
import com.scooterrental.webapp.scooter.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PublicController {

    @Autowired
    private ScooterService scooterService;




//    @PostMapping
//    public String processForm(Model model,
//                              @ModelAttribute("selectedStationBean") SelectedStation selectedStationBean,
//                              BindingResult bindingResult) {
//        model.addAttribute("stations", stationService.findAll());
////        model.addAttribute("cars", bindingResult.hasErrors() ? null : scooterService.findByStation(selectedStationBean.getStation()));
//        return "fragments/search-rentals";
//    }
}
