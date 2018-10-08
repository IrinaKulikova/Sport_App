package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Filiation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String caption;
    String country;
    String city;

    @Column(name = "index_city")
    String indexCity;
    String street;
    String building;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filiation", fetch = FetchType.EAGER)
    List<Contact> contacts = new ArrayList<>();

    public Filiation(String caption, String country, String city, String indexCity, String street, String building) {
        this.caption = caption;
        this.country = country;
        this.city = city;
        this.indexCity = indexCity;
        this.street = street;
        this.building = building;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Filiation() {
    }

    public void removeContact(Contact contact) {
        Contact curContact = contacts.stream().filter(c -> (c.getId() == contact.getId())).findFirst().get();
        contacts.remove(curContact);
    }
}
