package application.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String country;
    String city;
    String indexCity;
    String street;
    String building;
    String phoneNumber;

    public Contacts(String country, String city, String indexCity, String street, String building, String phoneNumber) {
        this.country = country;
        this.city = city;
        this.indexCity = indexCity;
        this.street = street;
        this.building = building;
        this.phoneNumber = phoneNumber;
    }

    public Contacts() {
    }
}
