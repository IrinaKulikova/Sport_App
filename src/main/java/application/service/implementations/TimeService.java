package application.service.implementations;

import application.entity.Time;
import application.repository.TimeRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TimeService implements EntityService<Time> {

    @Autowired
    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public List<Time> getAll() throws SQLException {
        return timeRepository.findAll();
    }

    @Override
    public Time getById(int id) throws SQLException {
        return timeRepository.findById(id).get();
    }

    @Override
    public Time save(Time time) throws SQLException {
        return timeRepository.save(time);
    }

    @Override
    public void delete(int id) throws SQLException {
        timeRepository.deleteById(id);
    }
}
