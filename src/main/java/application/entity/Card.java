package application.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Card{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    int id;

    @Column(name="pin_code")
    int pinCode;

    @Column(name="issue_date")
    String issueDate;

    @Column(name="expiration_date")
    String expirationDate;

}