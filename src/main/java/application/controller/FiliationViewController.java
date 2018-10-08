package application.controller;

import application.entity.ContactType;
import application.entity.Filiation;
import application.service.implementations.ContactTypeService;
import application.service.implementations.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filiation")
public class FiliationViewController {

    @Autowired
    private FiliationService filiationService;

    @Autowired
    private ContactTypeService contactTypeService;

    @GetMapping()
    public String index(Model model) {
        try {
            model.addAttribute("filiation", filiationService.getAll());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "filiation/filiation";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable int id, Model model) {
        Filiation filiation = new Filiation();
        List<ContactType> contactTypeList = new ArrayList<>();
        try {
            filiation = filiationService.getById(id);
            contactTypeList = contactTypeService.getAll();
        } catch (Exception ex) {
            filiation = new Filiation();
        }
        model.addAttribute("filiation", filiation);
        model.addAttribute("contact_types", contactTypeList);
        return "filiation/filiation_edit";
    }

    @GetMapping("/create")
    public String edit(Model model) {
        List<ContactType> contactTypeList = new ArrayList<>();
        try {
            contactTypeList = contactTypeService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("contact_types", contactTypeList);
        return "filiation/filiation_create";
    }
}