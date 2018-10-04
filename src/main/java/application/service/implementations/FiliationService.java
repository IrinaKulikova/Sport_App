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
    public List<Filiation> getAll()  {return filiationRepository.findAll(); }

    @Override
    public Filiation getById(int id) { return filiationRepository.findById(id).get();}

    @Override
    public void save(Filiation filial) { filiationRepository.save(filial); }

    @Override
    public void delete(int id) {filiationRepository.delete(filiationRepository.findById(id).get());}

    public void delete(Filiation filial) {filiationRepository.delete(filial);}
}