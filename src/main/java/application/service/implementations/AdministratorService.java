package application.service.implementations;

import application.entity.Administrator;
import application.repository.AdministratorRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AdministratorService implements EntityService<Administrator> {
    @Autowired
    AdministratorRepository repository;

    @Override
    public List<Administrator> getAll() {
        return repository.findAll();
    }

    @Override
    public Administrator getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Administrator administrator) {
        repository.save(administrator);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
