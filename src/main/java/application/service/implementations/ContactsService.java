package application.service.implementations;

import application.entity.Card;
import application.entity.Contacts;
import application.entity.News;
import application.repository.ContactsRepository;
import application.service.interfaces.IEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService implements IEntityService<Contacts> {

    @Autowired
    ContactsRepository repository;

    @Override
    public List<Contacts> getAll() {
        return repository.findAll();
    }

    @Override
    public Contacts getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void save(Contacts contacts) {
        repository.save(contacts);
    }

    @Override
    public void delete(Contacts contacts) {
        repository.delete(contacts);
    }
}
