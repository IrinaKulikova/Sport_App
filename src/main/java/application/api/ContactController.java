package application.api;

import application.entity.Contact;
import application.entity.Filial;
import application.entity.News;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.ContactService;
import application.service.implementations.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/1.0/contacts", produces = "application/json")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private FilialService filialService;

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
        try {
            Filial filial = filialService.getById(id);
            filial.addContact(contact);
            contact.setFilial(filial);
            filialService.save(filial);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Contact>(contact, ex.getMessage());
        }
        return new JSONResultOk<Contact>(contact);
    }

    @PutMapping("/{id}")
    public JSONResult<Contact> updateContact(@RequestBody Contact contact, @PathVariable int id) {
        Contact currentContact = contactService.getById(id);
        try {
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
