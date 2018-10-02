package application.service.implementations;

import application.entity.Card;
import application.entity.Contact;
import application.repository.CardRepository;
import application.repository.ContactRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements EntityService<Contact> {

    @Autowired
    ContactRepository repository;

    @Override
    public List<Contact> getAll() {return repository.findAll(); }

    @Override
    public Contact getById(int id) {return repository.findById(id).get(); }

    @Override
    public void save(Contact contact) { repository.save(contact); }

    @Override
    public void delete(int id) { repository.delete(repository.findById(id).get());}
}
