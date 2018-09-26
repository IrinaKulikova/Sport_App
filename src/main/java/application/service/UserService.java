package application.service;


import application.entity.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository users;

    public List<User> getAllUsers(){
        return users.findAll();
    }

    public User getUserById(int id){
        return users.getOne(id);
    }

    public void saveUser(User user){
        users.save(user);
    }

}
