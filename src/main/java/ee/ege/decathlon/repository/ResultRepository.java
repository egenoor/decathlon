package ee.ege.decathlon.repository;

import ee.ege.decathlon.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByAthlete_Id(Long id);
}
