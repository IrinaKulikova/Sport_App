package application.controller;

import application.entity.Filiation;
import application.service.implementations.ContactTypeService;
import application.service.implementations.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "filiation";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable int id, Model model) {
        Filiation filiation = null;
        try {
            filiation = filiationService.getById(id);
        } catch (Exception ex) {
            filiation = new Filiation();
        }
        model.addAttribute("filiation", filiation);
        model.addAttribute("contact_types", contactTypeService.getAll());
        return "filiation_edit";
    }

    @GetMapping("/create")
    public String edit(Model model) {
        model.addAttribute("filiation", new Filiation());
        model.addAttribute("contact_types", contactTypeService.getAll());
        return "filiation_edit";
    }
}