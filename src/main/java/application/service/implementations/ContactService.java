package application.service.implementations;

import application.entity.Contact;
import application.entity.ContactType;
import application.repository.ContactRepository;
import application.repository.ContactTypeRepository;
import application.repository.FiliationRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ContactService implements EntityService<Contact> {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.contactRepository = repository;
    }

    @Override
    public List<Contact> getAll() throws SQLException {
        return contactRepository.findAll();
    }

    @Override
    public Contact getById(int id) throws SQLException {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact save(Contact contact) throws SQLException {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(int id) throws SQLException {
        contactRepository.delete(contactRepository.findById(id).get());
    }

    public void delete(Contact contact) throws SQLException {
        contactRepository.delete(contact);
    }
}
