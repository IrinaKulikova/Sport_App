package application.api;

import application.entity.Card;
import application.entity.User;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.CardService;
import application.service.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/cards", produces = "application/json")
public class CardController {

    private final CardService cardService;
    private final UserService userService;

    @Autowired
    public CardController(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService = userService;
    }

    @GetMapping
    public JSONResult<List<Card>> getAll() {
        List<Card> cards = new ArrayList<>();
        try {
            cards = cardService.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(cards, ex.getMessage());
        }
        return new JSONResultOk<>(cards);
    }

    @GetMapping("/{id}")
    public JSONResult<Card> getById(@PathVariable("id") int id) {
        Card card = new Card();
        try {
            card = cardService.getById(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(card, ex.getMessage());
        }
        return new JSONResultOk<>(card);
    }

    @PutMapping("/{user_id}/{id}")
    public JSONResult<Card> update(@RequestBody Card card, @PathVariable("user_id") int user_id, @PathVariable("id") int id) {
        Card currentCard = new Card();
        try {
            currentCard = cardService.getById(id);
            if (currentCard == null) {
                return new JSONResultError<>(new Card(), "entity no find!");
            }
            currentCard.setExpirationDate(card.getExpirationDate());
            currentCard.setIssueDate(card.getIssueDate());
            currentCard.setPinCode(card.getPinCode());
            currentCard.setDescription(card.getDescription());
            currentCard.setUser(userService.getById(user_id));
            cardService.save(currentCard);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(currentCard, ex.getMessage());
        }
        return new JSONResultOk<>(currentCard);
    }

    @PostMapping("/{id}")
    public JSONResult<Card> add(@RequestBody Card card, @PathVariable int id) {
        User user = null;
        Card curCard = new Card();
        try {
            user = userService.getById(id);
            curCard.setPinCode(card.getPinCode());
            curCard.setIssueDate(card.getIssueDate());
            curCard.setExpirationDate(card.getExpirationDate());
            curCard.setDescription(card.getDescription());
            curCard.setUser(user);
            curCard = cardService.save(curCard);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(curCard, ex.getMessage());
        }
        return new JSONResultOk<>(curCard);
    }

    @DeleteMapping("/{user_id}/{id}")
    public JSONResult<Card> delete(@PathVariable int user_id, @PathVariable int id) {
        Card card = new Card();
        try {
            card = cardService.getById(id);
            cardService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(card, ex.getMessage());
        }
        return new JSONResultOk<>(card);
    }
}