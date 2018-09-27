package application.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = ContactType.class)
    @JoinColumn(name="fk_contact_type")
    ContactType contactType;

    String data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_filial")
    Filial filial;
}
