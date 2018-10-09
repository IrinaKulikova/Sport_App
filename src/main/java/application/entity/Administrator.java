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

    @Column(name="admin_hash")
    String adminHash;

    String email;

    public Administrator(){}

    public String getLogin() {
        return login;
    }

    public String getAdminHash() {
        return adminHash;
    }
}