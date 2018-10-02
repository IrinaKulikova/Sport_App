package application.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;
    String email;
    String phone;
    @Column(name = "user_hash")
    String userHash;


    @OneToMany(targetEntity = Card.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "card_user_id")

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        //FIXME: exception
        cards.remove(card);
    }
}