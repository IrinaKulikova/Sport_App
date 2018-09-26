package application.service;

import application.entities.Card;
import application.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
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
