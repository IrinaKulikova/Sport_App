package application.service.implementations;

import application.entity.Administrator;
import application.repository.AdministratorRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService implements EntityService<Administrator> {
    @Autowired
    AdministratorRepository repository;

    @Override
    public List<Administrator> getAll() throws Throwable {
        return repository.findAll();
    }

    @Override
    public Administrator getById(int id) throws Throwable {
        return repository.getOne(id);
    }

    @Override
    public void save(Administrator administrator) throws Throwable {
        repository.save(administrator);
    }

    @Override
    public void delete(int id) throws Throwable {
        repository.deleteById(id);
    }
}
