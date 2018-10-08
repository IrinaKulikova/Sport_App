package application.service.implementations;

import application.entity.Day;
import application.repository.DayRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Entity;

import java.util.List;
@Service
public class DayServise implements EntityService<Day> {
    @Autowired
    DayRepository dayRepository;
    @Override
    public List<Day> getAll() throws Exception {
        return dayRepository.findAll();
    }

    @Override
    public Day getById(int id) throws Exception {
        return dayRepository.findById(id).get();
    }

    @Override
    public Day save(Day day) throws Exception {
         return dayRepository.save(day);
    }

    @Override
    public void delete(int id) throws Exception {
         dayRepository.deleteById(id);
    }

}
