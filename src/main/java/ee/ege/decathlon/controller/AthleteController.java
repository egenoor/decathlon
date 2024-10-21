package ee.ege.decathlon.controller;

import ee.ege.decathlon.entity.Athlete;
import ee.ege.decathlon.repository.AthleteRepository;
import ee.ege.decathlon.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AthleteController {

    @Autowired
    AthleteService athleteService;

    @GetMapping("/athletes")
    public List<Athlete> getAthletes() {
        return athleteService.getAthletes();
    }

    @PostMapping("/athlete")
    public String saveAthlete(@RequestBody Athlete athlete) {
        athleteService.saveAthlete(athlete);
        return "Athlete saved";
    }
}
