package application.repository;

import application.entity.Filiation;
import application.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
    List<Training> findAllByFiliation(Filiation filiation);
}