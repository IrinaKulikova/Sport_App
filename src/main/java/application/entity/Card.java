package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_fk")
    @JsonIgnore
    private User user;

    @Column(name = "pin_code")
    int pinCode;

    @Column(name = "issue_date")
    String issueDate;

    @Column(name = "expiration_date")
    String expirationDate;

    String description;

    public Card() {
    }
}