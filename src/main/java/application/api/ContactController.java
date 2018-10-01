package application.api;

import application.entity.Contact;
import application.entity.Filial;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.ContactService;
import application.service.implementations.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/contacts", produces = "application/json")
public class ContactController {

    @Autowired
    private ContactService service;

    @Autowired
    private FilialService filialService;

    @GetMapping("/{id}")
    public JSONResult<Contact> getNewsById(@PathVariable("id") int id) {
        Contact contact = new Contact();
        try {
            contact = service.getById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Contact>(contact, ex.getMessage());
        }
        return new JSONResultOk<Contact>(contact);
    }

    @GetMapping
    public JSONResult<List<Contact>> getAll() {
        List<Contact> contacts = new ArrayList<>();
        try {
            contacts = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(contacts, ex.getMessage());
        }
        return new JSONResultOk<List<Contact>>(contacts);
    }


    @PostMapping("/{id}")
    public JSONResult<Contact> newNews(@RequestBody Contact contact, @PathVariable int id) {
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

    @DeleteMapping("/{id}")
    public JSONResult<Contact> deleteNews(@PathVariable int id) {
        Contact contact = new Contact();
        try {
            contact = service.getById(id);
            service.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(contact, ex.getMessage());
        }
        return new JSONResultOk<>(contact);
    }
}
