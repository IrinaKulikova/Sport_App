package application.service.implementations;

import application.entity.Contact;
import application.entity.Filial;
import application.repository.ContactRepository;
import application.repository.FilialRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FilialService implements EntityService<Filial> {

    @Autowired
    FilialRepository filialRepository;


    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Filial> getAll() throws IOException {
        return filialRepository.findAll();
    }

    @Override
    public Filial getById(int id) throws  IOException {
        return filialRepository.findById(id).get();
    }

    @Override
    public void save(Filial filial) throws IOException {
        filialRepository.save(filial);
    }

    @Override
    public void delete(int id) throws IOException {
        Filial filial=filialRepository.findById(id).get();
        filialRepository.delete(filial);
    }
}
