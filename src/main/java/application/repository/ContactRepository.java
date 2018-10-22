package application.repository;

import application.entity.Contact;
import application.entity.Filiation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByFiliation(Filiation filiation);
}
