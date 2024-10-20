package ee.ege.decathlon.repository;

import ee.ege.decathlon.entity.Athlete;
import ee.ege.decathlon.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}