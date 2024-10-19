package ee.ege.decathlon.controller;

import ee.ege.decathlon.entity.Athlete;
import ee.ege.decathlon.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AthleteController {

    @Autowired
    AthleteRepository athleteRepository;

    @GetMapping("/athletes")
    public List<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    @PostMapping("/athlete")
    public Athlete saveAthlete(@RequestBody Athlete athlete) {
        return athleteRepository.save(athlete);
    }
}
