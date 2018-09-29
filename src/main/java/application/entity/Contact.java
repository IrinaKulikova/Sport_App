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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = ContactType.class, optional = false)
    @JoinColumn(name="contact_type_id")
    @JsonIgnore
    ContactType contactType;

    String data;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "filial_id")
    @JsonIgnore
    Filial filial;

    public Contact() {
    }
}
