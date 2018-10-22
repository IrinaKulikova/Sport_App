package application.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

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

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "filiation", fetch = FetchType.EAGER)
    List<Contact> contacts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "filiation", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Training> trainings = new ArrayList<>();

    public Filiation() {
    }
}
