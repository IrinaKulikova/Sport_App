package application.api;


import application.entity.Administrator;
import application.entity.ContactType;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.AdministratorService;
import application.service.implementations.ContactTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/contacttypes", produces = "application/json")
public class ContactTypeController {

    @Autowired
    ContactTypeService contactTypeService;

    @GetMapping()
    public JSONResult<List<ContactType>> getAll() {
        List<ContactType> contactTypes = new ArrayList<>();
        try {
            contactTypes = contactTypeService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(contactTypes, ex.getMessage());
        }
        return new JSONResultOk<List<ContactType>>(contactTypes);
    }
}