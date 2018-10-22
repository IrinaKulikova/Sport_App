package application.api;

import application.entity.Contact;
import application.entity.Filiation;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.ContactService;
import application.service.implementations.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping(value = "/api/1.0/contacts", produces = "application/json")
public class ContactController {

    private final ContactService contactService;
    private final FiliationService filiationService;

    @Autowired
    public ContactController(FiliationService filiationService, ContactService contactService) {
        this.filiationService = filiationService;
        this.contactService = contactService;
    }

    @GetMapping("/{id}")
    public JSONResult<Contact> getById(@PathVariable("id") int id) {
        Contact contact = new Contact();
        try {
            contact = contactService.getById(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(contact, ex.getMessage());
        }
        return new JSONResultOk<>(contact);
    }

    @PostMapping("/{id}")
    public JSONResult<Contact> add(@RequestBody Contact contact, @PathVariable int id) {
        Filiation filiation = null;
        Contact newContact = new Contact();
        try {
            filiation = filiationService.getById(id);
            newContact.setFiliation(filiation);
            newContact.setData(contact.getData());
            newContact.setContactType(contact.getContactType());
            newContact.setFiliation(filiation);
            newContact = contactService.save(newContact);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(newContact, ex.getMessage());
        }
        return new JSONResultOk<>(newContact);
    }

    @PutMapping("/{id}")
    public JSONResult<Contact> update(@RequestBody Contact contact, @PathVariable int id) {
        Contact currentContact = null;
        try {
            currentContact = contactService.getById(id);
            currentContact.setData(contact.getData());
            contactService.save(currentContact);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(contact, ex.getMessage());
        }
        return new JSONResultOk<>(contact);
    }

    @DeleteMapping("/{id}")
    public JSONResult<Contact> delete(@PathVariable int id) {
        Contact contact = new Contact();
        try {
            contact = contactService.getById(id);
            contactService.delete(contact);
        } catch (Throwable ex) {
            ex.printStackTrace();
            return new JSONResultError<>(contact, ex.getMessage());
        }
        return new JSONResultOk<>(contact);
    }
}