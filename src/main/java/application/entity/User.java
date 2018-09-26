package application.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    int id;

    @Column(name="first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    String email;

    String phone;

    @ManyToOne(targetEntity = Card.class,cascade = CascadeType.ALL)
    int card_id;
}
