package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "contact_type")
public class ContactType {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    String name;

    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = Contact.class)
    @JoinColumn(name="contact_type_id")
    @JsonIgnore
    List<Contact> contacts = new ArrayList<>();

    public ContactType() {
    }
}