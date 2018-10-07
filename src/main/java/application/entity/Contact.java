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
    @JoinColumn(name = "contact_type_id")
    ContactType contactType;

    String data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filiation_id")
    @JsonIgnore
    Filiation filiation;

    public Contact() {
    }
}
