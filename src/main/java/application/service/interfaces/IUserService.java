package application.service.interfaces;

import application.entities.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void saveUser(User user);
}
