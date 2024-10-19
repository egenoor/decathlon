package ee.ege.decathlon.repository;

import ee.ege.decathlon.entity.Athlete;
import ee.ege.decathlon.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}