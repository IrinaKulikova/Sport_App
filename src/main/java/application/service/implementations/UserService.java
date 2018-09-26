package application.service.implementations;


import application.entities.User;
import application.repository.CardRepository;
import application.repository.UserRepository;
import application.service.interfaces.ICardService;
import application.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

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
