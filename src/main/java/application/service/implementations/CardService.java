package application.service.implementations;

import application.entity.Card;
import application.repository.CardRepository;
import application.service.interfaces.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICardService {
    @Autowired
    CardRepository cards;

    public List<Card> getAllCards(){
        return cards.findAll();
    }

    public Card getCardById(int id){
        return cards.getOne(id);
    }

    public void saveCard(Card card){
        cards.save(card);
    }

}
