package application.repository;

import application.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
    List<Training> findAllByFiliation(Filiation filiation);
    List<Training> findAllByDayAndTimeAndFiliation(Day day, Time time, Filiation filiation);
}