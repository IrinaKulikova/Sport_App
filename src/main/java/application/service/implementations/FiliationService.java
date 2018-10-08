package application.service.implementations;

import application.entity.Filiation;
import application.repository.ContactRepository;
import application.repository.FiliationRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliationService implements EntityService<Filiation> {

    @Autowired
    FiliationRepository filiationRepository;

    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Filiation> getAll() throws Exception {
        return filiationRepository.findAll();
    }

    @Override
    public Filiation getById(int id) throws Exception {
        return filiationRepository.findById(id).get();
    }

    @Override
    public Filiation save(Filiation filial) throws Exception {
        return filiationRepository.save(filial);
    }

    @Override
    public void delete(int id) throws Exception {
        filiationRepository.delete(filiationRepository.findById(id).get());
    }

    public void delete(Filiation filial) throws Exception {
        filiationRepository.delete(filial);
    }
}