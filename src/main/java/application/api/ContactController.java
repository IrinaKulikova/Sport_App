package application.api;

import application.entity.Card;
import application.entity.Contact;
import application.entity.Filiation;
import application.entity.User;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.ContactService;
import application.service.implementations.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/1.0/contacts", produces = "application/json")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private FiliationService filiationService;

    @GetMapping("/{id}")
    public JSONResult<Contact> getContactById(@PathVariable("id") int id) {
        Contact contact = new Contact();
        try {
            contact = contactService.getById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Contact>(contact, ex.getMessage());
        }
        return new JSONResultOk<Contact>(contact);
    }

    @PostMapping("/{id}")
    public JSONResult<Contact> addContact(@RequestBody Contact contact, @PathVariable int id) {
        Filiation filiation = null;
        Contact newContact = new Contact();
        try {
            filiation = filiationService.getById(id);
            newContact.setFiliation(filiation);
            newContact.setData(contact.getData());
            newContact.setContactType(contact.getContactType());
            newContact.setFiliation(filiation);
            newContact = contactService.save(newContact);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Contact>(newContact, ex.getMessage());
        }
        return new JSONResultOk<Contact>(newContact);
    }

    @PutMapping("/{id}")
    public JSONResult<Contact> updateContact(@RequestBody Contact contact, @PathVariable int id) {
        Contact currentContact = null;
        try {
            currentContact = contactService.getById(id);
            currentContact.setData(contact.getData());
            contactService.save(currentContact);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Contact>(contact, ex.getMessage());
        }
        return new JSONResultOk<Contact>(contact);
    }

    @DeleteMapping("/{id}")
    public JSONResult<Contact> deleteContact(@PathVariable int id) {
        Contact contact = new Contact();
        try {
            contact = contactService.getById(id);
            contactService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(contact, ex.getMessage());
        }
        return new JSONResultOk<>(contact);
    }
}
