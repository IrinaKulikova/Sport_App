package application.service.implementations;

import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.repository.ScheduleRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ScheduleService implements EntityService<Schedule> {
    @Autowired
    ScheduleRepository repository;

    @Override
    public List<Schedule> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public Schedule getById(int id) throws Exception {
        return repository.findById(id).get();
    }

    @Override
    public Schedule save(Schedule schedule) throws Exception {
        return repository.save(schedule);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.deleteById(id);
    }
}
