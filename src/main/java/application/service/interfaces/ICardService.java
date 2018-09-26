package application.service.interfaces;

import application.entities.Card;

import java.util.List;

public interface ICardService {
    public List<Card> getAllCards();
    public Card getCardById(int id);
    public void saveCard(Card card);
}
