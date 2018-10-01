package application.service.implementations;

import application.entity.ScheduleEvent;
import application.repository.ScheduleEventRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchedulesEventServise implements EntityService<ScheduleEvent> {
    @Autowired
    ScheduleEventRepository repository;
    @Override
    public List<ScheduleEvent> getAll() {
        return repository.findAll();
    }

    @Override
    public ScheduleEvent getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void save(ScheduleEvent scheduleEvent) {
        repository.save(scheduleEvent);
    }

    @Override
    public void delete(ScheduleEvent scheduleEvent) {
        repository.delete(scheduleEvent);
    }
}
