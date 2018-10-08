package application.service.implementations;

import application.entity.Contact;
import application.entity.ContactType;
import application.repository.ContactRepository;
import application.repository.ContactTypeRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactTypeService implements EntityService<ContactType> {
    @Autowired
    ContactTypeRepository repository;

    @Override
    public List<ContactType> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public ContactType getById(int id) throws Exception {
        return repository.findById(id).get();
    }

    @Override
    public ContactType save(ContactType contactType) throws Exception {
        return repository.save(contactType);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.delete(repository.findById(id).get());
    }
}
