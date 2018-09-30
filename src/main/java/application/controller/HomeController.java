package application.controller;

import application.entity.Administrator;
import application.service.helper.HashHelper;
import application.service.implementations.AdministratorService;
import application.service.implementations.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest req){
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean exist = false;
        try {
            List<Administrator> admins = administratorService.getAll();

            for(Administrator a:admins){
                if(login.equals(a.getLogin())&&password.equals(a.getPassword())){
                    exist = true;
                    break;
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        if(exist){

            HttpSession session = req.getSession();
            try {
                session.setAttribute("identifier",HashHelper.makeSHA1Hash(login+password+"Sport_App"));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "home";
    }
}