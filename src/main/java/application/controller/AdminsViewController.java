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
    public String edit(@PathVariable int id, Model model, HttpServletRequest req) {
        Administrator admin = new Administrator();
        try {
            admin = administratorService.getById(id);
        } catch (Exception ex) {
        }
        model.addAttribute("admin", admin);
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        model.addAttribute("login", login);
        return "admins/admins";
    }

    @GetMapping("/create")
    public String edit(Model model) {
        return "admins/admin_create";
    }
}