package application.service.implementations;

import application.entity.Training;
import application.repository.TrainingRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService implements EntityService<Training> {

    final TrainingRepository repository;

    @Autowired
    public TrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Training> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public Training getById(int id) throws Exception {
        return repository.findById(id).get();
    }

    @Override
    public Training save(Training training) throws Exception {
        return repository.save(training);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.deleteById(id);
    }
}
