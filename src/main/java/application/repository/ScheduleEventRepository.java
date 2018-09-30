package application.repository;

import application.entity.ScheduleEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleEventRepository extends JpaRepository<ScheduleEvent,Integer> {
}
