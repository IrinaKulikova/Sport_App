package application.service.implementations;

import application.entity.Card;
import application.repository.CardRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CardService implements EntityService<Card> {
    @Autowired
    CardRepository repository;

    @Override
    public List<Card> getAll() throws IOException {
        return repository.findAll();
    }

    @Override
    public Card getById(int id) throws IOException {
        return repository.findById(id).get();
    }

    @Override
    public void save(Card card) throws IOException {
        repository.save(card);
    }

    @Override
    public void delete(int id) throws IOException {
        repository.delete(repository.findById(id).get());
    }
}