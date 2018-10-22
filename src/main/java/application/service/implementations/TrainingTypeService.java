package application.service.implementations;

import application.entity.TrainingType;
import application.repository.TrainingTypeRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TrainingTypeService implements EntityService<TrainingType> {

    private final TrainingTypeRepository repository;

    @Autowired
    public TrainingTypeService(TrainingTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TrainingType> getAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public TrainingType getById(int id)throws SQLException {
        return repository.findById(id).get();
    }

    @Override
    public TrainingType save(TrainingType scheduleEvent) throws SQLException {
        return repository.save(scheduleEvent);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.deleteById(id);
    }
}
