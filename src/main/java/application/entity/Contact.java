package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ContactType.class)
    @JoinColumn(name = "contact_type_fk")
    ContactType contactType;

    String data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filiation_fk")
    @JsonIgnore
    Filiation filiation;

    public Contact() {
    }
}
