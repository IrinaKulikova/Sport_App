package application.service.implementations;

import application.entity.Filial;
import application.repository.FilialRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.metamodel.EntityType;
import java.util.List;

public class FilialService implements EntityService<Filial> {

    @Autowired
    FilialRepository repository;

    @Override
    public List<Filial> getAll() {
        return repository.findAll();
    }

    @Override
    public Filial getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void save(Filial filial) {
        repository.save(filial);
    }

    @Override
    public void delete(Filial filial) {
        repository.delete(filial);
    }
}
