package ee.ege.decathlon.controller;

import ee.ege.decathlon.dto.AthleteWithPoints;
import ee.ege.decathlon.repository.ResultRepository;
import ee.ege.decathlon.service.ResultService;
import ee.ege.decathlon.type.AddRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/events")
    public String[] getEvents() {
        return AVAILABLE_EVENTS;
    }

    @GetMapping("/results/{id}")
    public int getAthleteResults(@PathVariable Long id) {
        return resultService.getPointsSum(id);
    }

    @GetMapping("/results")
    public List<AthleteWithPoints> getResults() {
        return resultService.getAthletesSummary();
    }

    @PostMapping("/result")
    public String saveEvent(@RequestBody AddRequestBody addRequestBody) {
        resultService.saveResult(addRequestBody);
        return "Result saved";
    }
}
