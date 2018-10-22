package application.service.implementations;

import application.entity.Training;
import application.repository.TrainingRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TrainingService implements EntityService<Training> {

    final TrainingRepository repository;

    @Autowired
    public TrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Training> getAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Training getById(int id) throws SQLException {
        return repository.findById(id).get();
    }

    @Override
    public Training save(Training training) throws SQLException {
        return repository.save(training);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.deleteById(id);
    }
}
