package application.controller;

import application.entity.Administrator;
import application.helper.HashHelper;
import application.service.implementations.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/")
    public String index() {
        return "redirect:/filiation";
    }

    @GetMapping("/logout")
    public String logoutGet(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.removeAttribute("identifier");
        return "login";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            List<Administrator> admins = administratorService.getAll();

            for (Administrator a : admins) {
                //Если такой логин существует - проверяем пароль
                if (login.equals(a.getLogin())) {
                    String adminHash = a.getAdminHash();
                    String saltHash = adminHash.substring(40);
                    System.out.println(saltHash);
                    String checkHash = HashHelper.makeSHA1Hash(saltHash + password) + saltHash;
                    if (checkHash.equals(adminHash)) {
                        HttpSession session = req.getSession();
                        try {
                            session.setAttribute("identifier", HashHelper.makeSHA1Hash(adminHash));
                            session.setAttribute("login", login);
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
        return "filiations/filiation";
    }
}