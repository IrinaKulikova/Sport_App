package application.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ContactType {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    String name;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Contact.class)
    @JoinColumn(name="fk_contact_type")
    List<Contact> contacts = new ArrayList<>();
}