package application.service.implementations;

import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.repository.ScheduleRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SheduleServise implements EntityService<Schedule> {
    @Autowired
    ScheduleRepository repository;
    @Override
    public List<Schedule> getAll() {
      return repository.findAll();
    }

    @Override
    public Schedule getById(int id) {
       return repository.getOne(id);
    }

    @Override
    public void save(Schedule schedule) {
         repository.save(schedule);
    }

    @Override
    public void delete(Schedule schedule) {
        repository.delete(schedule);
    }
}
