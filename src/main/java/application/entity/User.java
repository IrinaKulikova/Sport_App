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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<Card> cards = new ArrayList<>();

    public User(String firstName, String lastName, String phone, String email, String hash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.userHash = hash;
    }

    public User() {
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        Card curCard = cards.stream().filter(c -> (c.getId() == card.getId())).findFirst().get();
        cards.remove(curCard);
    }
}