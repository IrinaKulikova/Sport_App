package application.service.implementations;

import application.entity.ContactType;
import application.repository.ContactTypeRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ContactTypeService implements EntityService<ContactType> {

    private final ContactTypeRepository repository;

    @Autowired
    public ContactTypeService(ContactTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ContactType> getAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public ContactType getById(int id) throws SQLException {
        return repository.findById(id).get();
    }

    @Override
    public ContactType save(ContactType contactType) throws SQLException {
        return repository.save(contactType);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.delete(repository.findById(id).get());
    }
}
