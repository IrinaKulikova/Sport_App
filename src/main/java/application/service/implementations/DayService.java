package application.service.implementations;

import application.entity.Day;
import application.repository.DayRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class DayService implements EntityService<Day> {

    private final DayRepository dayRepository;

    @Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public List<Day> getAll() throws SQLException {
        return dayRepository.findAll();
    }

    @Override
    public Day getById(int id) throws SQLException {
        return dayRepository.findById(id).get();
    }

    @Override
    public Day save(Day day) throws SQLException {
         return dayRepository.save(day);
    }

    @Override
    public void delete(int id) throws SQLException {
         dayRepository.deleteById(id);
    }

}
