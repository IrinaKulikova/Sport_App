package application.service.implementations;

import application.entity.Contact;
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
    private final FiliationRepository filiationRepository;
    private final ContactTypeRepository contactTypeRepository;

    @Autowired
    public ContactService(ContactRepository repository,
                          FiliationRepository filiationRepository,
                          ContactTypeRepository contactTypeRepository) {
        this.contactRepository = repository;
        this.filiationRepository = filiationRepository;
        this.contactTypeRepository = contactTypeRepository;
    }

    @Override
    public List<Contact> getAll() throws SQLException {
        return contactRepository.findAll();
    }

    @Override
    public Contact getById(int id) throws SQLException {
        Contact contact = contactRepository.findById(id).get();
        contact.setContactType(contactTypeRepository.findById(contact.getContactType().getId()).get());
        contact.setFiliation(filiationRepository.findById(contact.getFiliation().getId()).get());
        return contact;
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
