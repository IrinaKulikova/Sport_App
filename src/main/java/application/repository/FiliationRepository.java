package application.repository;

import application.entity.Filiation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliationRepository extends JpaRepository<Filiation, Integer> {
}
