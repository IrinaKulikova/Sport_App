package application.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String login;
    String email;

    @Column(name = "admin_hash")
    String adminHash;

    public Administrator() {
    }
}