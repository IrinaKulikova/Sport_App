package application.controller;

import application.entity.Administrator;
import application.service.helper.HashHelper;
import application.service.implementations.AdministratorService;
import application.service.implementations.CardService;
import application.service.implementations.UserService;
import application.service.implementations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private FiliationService filiationService;

    @GetMapping("/")
    public String index(Model model) {
        try {
            model.addAttribute("filiations",filiationService.getAll());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "filiation";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest req){
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            List<Administrator> admins = administratorService.getAll();

            for(Administrator a:admins){
                //Если такой логин существует - проверяем пароль
                if(login.equals(a.getLogin())) {
                    String adminHash = a.getAdminHash();
                    String saltHash = adminHash.substring(40);
                    System.out.println(saltHash);
                    String checkHash = HashHelper.makeSHA1Hash(saltHash+password)+saltHash;
                    if(checkHash.equals(adminHash)){
                        HttpSession session = req.getSession();
                        try {
                            session.setAttribute("identifier",HashHelper.makeSHA1Hash(adminHash));
                        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                }
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "filiation";
    }
}