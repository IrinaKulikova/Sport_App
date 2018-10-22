package application.service.implementations;

import application.entity.Contact;
import application.repository.ContactRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ContactService implements EntityService<Contact> {

    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Contact> getAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Contact getById(int id) throws SQLException {
        return repository.findById(id).get();
    }

    @Override
    public Contact save(Contact contact) throws SQLException {
        return repository.save(contact);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.delete(repository.findById(id).get());
    }
}
