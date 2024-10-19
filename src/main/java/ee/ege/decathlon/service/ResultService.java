package ee.ege.decathlon.service;

import ee.ege.decathlon.entity.Athlete;
import ee.ege.decathlon.entity.Result;
import ee.ege.decathlon.repository.AthleteRepository;
import ee.ege.decathlon.repository.ResultRepository;
import ee.ege.decathlon.type.AddRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    ResultRepository resultRepository;

    public void saveResult(AddRequestBody addRequestBody) {
        Athlete athlete = athleteRepository.findById(addRequestBody.getAthleteId()).orElseThrow();
        Result result = new Result();
        result.setAthlete(athlete);
        result.setPoints(addRequestBody.getPoints());
        result.setEvent(addRequestBody.getEvent());
        resultRepository.save(result);
    }

    public int getPointsSum(List<Result> results) {
        // for each event in results return the players points sum
        int sum = 0;
        for (Result r: results) {
            sum += r.getPoints();
        }
        return sum;
    }
}
