package application.api;

import application.dto.UserDTO;
import application.entity.User;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.helper.HashHelper;
import application.service.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/1.0/users", produces = "application/json")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public JSONResult<List<User>> getAll() {
        List<User> users = new ArrayList<>();
        try {
            users = userService.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(users, ex.getMessage());
        }
        return new JSONResultOk<>(users);
    }

    @GetMapping("/{id}")
    public JSONResult<User> getById(@PathVariable("id") int id) {
        User user = new User();
        try {
            user = userService.getById(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(user, ex.getMessage());
        }
        return new JSONResultOk<>(user);
    }

    @PutMapping("/{id}")
    public JSONResult<User> update(@RequestBody UserDTO user, @PathVariable("id") int id) {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(currentUser, ex.getMessage());
        }
        return new JSONResultOk<>(currentUser);
    }

    @PostMapping
    public JSONResult<User> add(@RequestBody UserDTO user) {
        User newUser = new User(user.getFirstName(), user.getLastName(), user.getPhone(),
                                user.getEmail(), HashHelper.getHash(user.getPassword()));
        try {
            userService.save(newUser);
            newUser.setUserHash("hidden");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(newUser, ex.getMessage());
        }
        return new JSONResultOk<>(newUser);
    }

    @DeleteMapping("/{id}")
    public JSONResult<User> delete(@PathVariable int id) {
        User user = new User();
        try {
            user = userService.getById(id);
            userService.delete(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(user, ex.getMessage());
        }
        return new JSONResultOk<>(user);
    }
}