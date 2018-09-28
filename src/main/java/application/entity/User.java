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
    String firstName;
    String lastName;
    String email;
    String phone;

    @OneToMany(targetEntity = Card.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="fk_card_user")
    private List<Card> cards = new ArrayList<>();
}