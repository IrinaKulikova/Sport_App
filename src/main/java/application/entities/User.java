package application.entities;

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

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "id")
    int card_id;
}
