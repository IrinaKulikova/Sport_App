package application.service.implementations;

import application.entity.Filiation;
import application.repository.ContactRepository;
import application.repository.FiliationRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FiliationService implements EntityService<Filiation> {

    private final FiliationRepository filiationRepository;

    @Autowired
    public FiliationService(FiliationRepository filiationRepository) {
        this.filiationRepository = filiationRepository;
    }

    @Override
    public List<Filiation> getAll()throws SQLException {
        return filiationRepository.findAll();
    }

    @Override
    public Filiation getById(int id) throws SQLException {
        return filiationRepository.findById(id).get();
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