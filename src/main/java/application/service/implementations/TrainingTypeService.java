package application.service.implementations;

import application.entity.TrainingType;
import application.repository.TrainingTypeRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingTypeService implements EntityService<TrainingType> {
    @Autowired
    TrainingTypeRepository repository;

    @Override
    public List<TrainingType> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public TrainingType getById(int id) throws Exception {
        return repository.findById(id).get();
    }

    @Override
    public TrainingType save(TrainingType scheduleEvent) throws Exception {
        return repository.save(scheduleEvent);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.deleteById(id);
    }
}
