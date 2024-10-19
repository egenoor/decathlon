package ee.ege.decathlon.service;

import ee.ege.decathlon.entity.Athlete;
import ee.ege.decathlon.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {

    @Autowired
    AthleteRepository athleteRepository;

    public void saveAthlete(Athlete athlete) {
        athleteRepository.save(athlete);
    }
}
