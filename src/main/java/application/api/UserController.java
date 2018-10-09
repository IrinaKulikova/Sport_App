package application.api;

import application.dto.UserDTO;
import application.entity.Card;
import application.entity.User;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.helper.HashHelper;
import application.service.implementations.CardService;
import application.service.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/1.0/users", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CardService cardService;

    @GetMapping("/{id}")
    public JSONResult<User> getUserById(@PathVariable("id") int id) {
        User user = new User();
        try {
            user = userService.getById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<User>(user, ex.getMessage());
        }
        return new JSONResultOk<User>(user);
    }

    @GetMapping
    public JSONResult<List<User>> getAll() {
        List<User> users = new ArrayList<>();
        try {
            users = userService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(users, ex.getMessage());
        }
        return new JSONResultOk<List<User>>(users);
    }

    @PutMapping("/{id}")
    public JSONResult<User> updateUser(@RequestBody UserDTO user, @PathVariable("id") int id) {
        User currentUser = new User();
        try {
            currentUser = userService.getById(id);
            if (currentUser == null) {
                return new JSONResultError<>(currentUser, "entity no find!");
            }
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setPhone(user.getPhone());
            currentUser.setEmail(user.getEmail());
            String pass = user.getPassword();
            if(pass != null && !pass.equals("")){
                currentUser.setUserHash(HashHelper.getHash(user.getPassword()));
            }
            userService.save(currentUser);
            currentUser.setUserHash("hidden");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(currentUser, ex.getMessage());
        }
        return new JSONResultOk<>(currentUser);
    }

    @PostMapping
    public JSONResult<User> addUser(@RequestBody UserDTO user) {
        User newUser = new User(user.getFirstName(), user.getLastName(), user.getPhone(),
                                user.getEmail(), HashHelper.getHash(user.getPassword()));
        try {
            userService.save(newUser);
            newUser.setUserHash("hidden");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<User>(newUser, ex.getMessage());
        }
        return new JSONResultOk<User>(newUser);
    }

    @DeleteMapping("/{id}")
    public JSONResult<User> deleteUser(@PathVariable int id) {
        User user = new User();
        try {
            user = userService.getById(id);
            userService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(user, ex.getMessage());
        }
        return new JSONResultOk<>(user);
    }
}