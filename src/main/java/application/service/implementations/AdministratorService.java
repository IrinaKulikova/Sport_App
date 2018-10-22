package application.service.implementations;

import application.entity.Administrator;
import application.repository.AdministratorRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AdministratorService implements EntityService<Administrator> {

    private final AdministratorRepository repository;

    @Autowired
    public AdministratorService(AdministratorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Administrator> getAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Administrator getById(int id) throws SQLException {
        return repository.findById(id).get();
    }

    @Override
    public Administrator save(Administrator administrator) throws SQLException {
        return repository.save(administrator);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.deleteById(id);
    }
}
