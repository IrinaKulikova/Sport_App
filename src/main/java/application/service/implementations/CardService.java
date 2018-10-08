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
    public List<Card> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public Card getById(int id) throws Exception {
        return repository.findById(id).get();
    }

    @Override
    public Card save(Card card) throws Exception {
        return repository.save(card);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.delete(repository.findById(id).get());
    }
}