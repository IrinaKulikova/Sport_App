package application.service.implementations;

import application.entity.Training;
import application.repository.*;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TrainingService implements EntityService<Training> {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository repository) {
        this.trainingRepository = repository;
    }

    @Override
    public List<Training> getAll() throws SQLException {
        return trainingRepository.findAll();
    }

    @Override
    public Training getById(int id) throws SQLException {
        return trainingRepository.findById(id).get();
    }

    @Override
    public Training save(Training training) throws SQLException {
        List<Training> trainings = trainingRepository.findAllByDayAndTimeAndFiliation(
                training.getDay(), training.getTime(), training.getFiliation());
        if (trainings.size() > 0) {
            for (int i = 0; i < trainings.size(); i++) {
                delete(trainings.get(i).getId());
            }
        }
        return trainingRepository.save(training);
    }

    @Override
    public void delete(int id) throws SQLException {
        trainingRepository.deleteById(id);
    }
}
