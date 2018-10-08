package application.controller;

import application.service.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UsersViewController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String users(Model model) {
        try {
            model.addAttribute("users",userService.getAll());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "users/users";
    }

    @GetMapping("/edit/{id}")
    public String userEdit(@PathVariable int id, Model model){
        try {
            model.addAttribute("user",userService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "users/user_details";
    }

    @GetMapping("/create")
    public String userCreate(){
        return "users/user_create";
    }
}