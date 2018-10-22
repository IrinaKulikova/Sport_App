package application.service.implementations;

import application.entity.Card;
import application.repository.CardRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CardService implements EntityService<Card> {

    private final CardRepository repository;

    @Autowired
    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Card> getAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Card getById(int id) throws SQLException {
        return repository.findById(id).get();
    }

    @Override
    public Card save(Card card) throws SQLException {
        return repository.save(card);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.delete(repository.findById(id).get());
    }
}