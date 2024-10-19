package ee.ege.decathlon.controller;

import ee.ege.decathlon.entity.Athlete;
import ee.ege.decathlon.entity.Result;
import ee.ege.decathlon.repository.AthleteRepository;
import ee.ege.decathlon.repository.ResultRepository;
import ee.ege.decathlon.service.ResultService;
import ee.ege.decathlon.type.AddRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
public class ResultController {
    private final String[] AVAILABLE_EVENTS = {
            "HUNDRED_METRES",
            "LONG_JUMP",
            "SHOT_PUT",
            "HIGH_JUMP",
            "FOUR_HUNDRED_METRES",
            "HUNDRED_TEN_METRE_HURDLE",
            "DISCUS_THROW",
            "JAVELIN_THROW",
            "THOUSAND_FIVE_HUNDRED_METRES"
    };

    @Autowired
    ResultService resultService;

    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/events")
    public String[] getEvents() {
        return AVAILABLE_EVENTS;
    }

    @GetMapping("/results/{id}")
    public int getAthleteResults(@PathVariable Long id) {
        List<Result> results = resultRepository.findByAthlete_Id(id);
        return resultService.getPointsSum(results);
    }

    @GetMapping("/results")
    public List<Result> getResults() {
        return resultRepository.findAll();
    }

    @PostMapping("/result")
    public String saveEvent(@RequestBody AddRequestBody addRequestBody) {
        resultService.saveResult(addRequestBody);
        return "Result saved";
    }
}
