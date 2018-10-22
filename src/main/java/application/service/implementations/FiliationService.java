package application.service.implementations;

import application.entity.Filiation;
import application.repository.ContactRepository;
import application.repository.FiliationRepository;
import application.repository.TrainingRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FiliationService implements EntityService<Filiation> {

    private final FiliationRepository filiationRepository;

    private final TrainingRepository trainingRepository;

    @Autowired
    public FiliationService(FiliationRepository filiationRepository, TrainingRepository trainingRepository) {
        this.filiationRepository = filiationRepository;
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<Filiation> getAll() throws SQLException {
        return filiationRepository.findAll();
    }

    @Override
    public Filiation getById(int id) throws SQLException {
        Filiation filiation = filiationRepository.findById(id).get();
        filiation.setTrainings(trainingRepository.findAllByFiliation(filiation));
        return filiation;
    }

    @Override
    public Filiation save(Filiation filial) throws SQLException {
        return filiationRepository.save(filial);
    }

    @Override
    public void delete(int id) throws SQLException {
        filiationRepository.delete(filiationRepository.findById(id).get());
    }

    public void delete(Filiation filial) throws SQLException {
        filiationRepository.delete(filial);
    }
}