package application.api;


import application.entity.ContactType;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.ContactTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/contacttypes", produces = "application/json")
public class ContactTypeController {

    private final ContactTypeService contactTypeService;

    @Autowired
    public ContactTypeController(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @GetMapping()
    public JSONResult<List<ContactType>> getAll() {
        List<ContactType> contactTypes = new ArrayList<>();
        try {
            contactTypes = contactTypeService.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(contactTypes, ex.getMessage());
        }
        return new JSONResultOk<>(contactTypes);
    }
}