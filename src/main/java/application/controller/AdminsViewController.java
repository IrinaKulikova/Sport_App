package application.controller;

import application.entity.Administrator;
import application.entity.ContactType;
import application.entity.Filiation;
import application.service.implementations.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminsViewController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping()
    public String index(Model model) {
        try {
            model.addAttribute("admins", administratorService.getAll());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "admins/admins";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable int id, Model model) {
        Administrator admin = new Administrator();
        try {
            admin = administratorService.getById(id);
        } catch (Exception ex) {
        }
        model.addAttribute("admin", admin);
        return "admins/admin_edit";
    }

    @GetMapping("/create")
    public String edit(Model model) {
        return "admins/admin_create";
    }
}