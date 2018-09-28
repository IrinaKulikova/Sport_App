package application.service.implementations;

import application.entity.Contact;
import application.entity.Filial;
import application.repository.ContactRepository;
import application.repository.FilialRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilialService implements EntityService<Filial> {

    @Autowired
    FilialRepository filialRepository;


    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Filial> getAll() {
        return filialRepository.findAll();
    }

    @Override
    public Filial getById(int id) {
        List<Contact> contacts = contactRepository.findAll();
        Filial filial = filialRepository.findById(id).get();
        filial.setContacts(contacts);
        return filial;
    }

    @Override
    public void save(Filial filial) {
        filialRepository.save(filial);
    }

    @Override
    public void delete(Filial filial) {
        filialRepository.delete(filial);
    }
}
