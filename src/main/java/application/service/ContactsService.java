package application.service;

import application.entity.Contacts;
import application.entity.News;
import application.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {

    @Autowired
    ContactsRepository repository;

    public List<Contacts> findAll() {
        return repository.findAll();
    }

    public void save(Contacts contacts) {
        repository.save(contacts);
    }

    public void delete(Contacts contacts) {repository.delete(contacts);
    }
}
