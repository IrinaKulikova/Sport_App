package application.api;

import application.entity.User;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//TODO: postman
@RestController
@RequestMapping(value = "/api/1.0/users", produces = "application/json")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public JSONResult<User> getUserById(@PathVariable("id") int id) {
        User user = new User();
        try {
            user = service.getById(id);
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
            users = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(users, ex.getMessage());
        }
        return new JSONResultOk<List<User>>(users);
    }

    @PutMapping("/{id}")
    public JSONResult<User> updateUser(@RequestBody User user, @PathVariable("id") int id) {
        User currentUser = new User();
        try {
            currentUser = service.getById(id);
            if (currentUser == null) {
                return new JSONResultError<>(currentUser, "entity no find!");
            }
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setEmail(user.getEmail());
            currentUser.setPhone(user.getPhone());
            currentUser.setEmail(user.getEmail());
            service.save(currentUser);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(currentUser, ex.getMessage());
        }
        return new JSONResultOk<>(currentUser);
    }

    @PostMapping
    public JSONResult<User> addUser(@RequestBody User user) {
        try {
            service.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<User>(user, ex.getMessage());
        }
        return new JSONResultOk<User>(user);
    }

    @DeleteMapping("/{id}")
    public JSONResult<User> deleteUser(@PathVariable int id) {
        User user = new User();
        try {
            user = service.getById(id);
            service.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(user, ex.getMessage());
        }
        return new JSONResultOk<>(user);
    }
}