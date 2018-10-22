package application.controller;

import application.service.implementations.CardService;
import application.service.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;


@Controller
@RequestMapping("/users")
public class UsersViewController {

    private final UserService userService;
    private final CardService cardService;

    @Autowired
    public UsersViewController(UserService userService, CardService cardService) {
        this.userService = userService;
        this.cardService = cardService;
    }

    @GetMapping()
    public String users(Model model) {
        try {
            model.addAttribute("users",userService.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "users/users";
    }

    @GetMapping("/{id}")
    public String userEdit(@PathVariable int id, Model model){
        try {
            model.addAttribute("user",userService.getById(id));
            model.addAttribute("cards",cardService.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "users/user_edit";
    }

    @GetMapping("/create")
    public String userCreate(){
        return "users/user_create";
    }
}