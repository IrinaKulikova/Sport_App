package application.controller;

import application.entity.Administrator;
import application.service.implementations.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping("/admins")
public class AdminsViewController {

    private final AdministratorService administratorService;

    @Autowired
    public AdminsViewController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping()
    public String index(Model model) {
        try {
            model.addAttribute("admins", administratorService.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "admins/admins";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable int id, Model model, HttpServletRequest req) {
        Administrator admin = new Administrator();
        try {
            admin = administratorService.getById(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        model.addAttribute("admin", admin);
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        model.addAttribute("login", login);
        return "admins/admin_edit";
    }

    @GetMapping("/create")
    public String edit() {
        return "admins/admin_create";
    }
}