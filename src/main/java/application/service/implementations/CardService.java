package application.service.implementations;

import application.entity.Card;
import application.repository.CardRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements EntityService<Card> {
    @Autowired
    CardRepository repository;

    @Override
    public List<Card> getAll() {
        return repository.findAll();
    }

    @Override
    public Card getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void save(Card card) {
        repository.save(card);
    }

    @Override
    public void delete(Card card) {
        repository.delete(card);
    }
}
