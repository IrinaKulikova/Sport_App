package application.service.implementations;

import application.entity.ScheduleEvent;
import application.repository.ScheduleEventRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SchedulesEventService implements EntityService<ScheduleEvent> {
    @Autowired
    ScheduleEventRepository repository;

    @Override
    public List<ScheduleEvent> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public ScheduleEvent getById(int id) throws Exception {
        return repository.getOne(id);
    }

    @Override
    public ScheduleEvent save(ScheduleEvent scheduleEvent) throws Exception {
        return repository.save(scheduleEvent);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.deleteById(id);
    }
}
