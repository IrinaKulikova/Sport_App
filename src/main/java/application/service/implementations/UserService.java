package application.service.implementations;


import application.entity.User;
import application.repository.UserRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService implements EntityService<User> {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public User getById(int id) throws SQLException {
        return repository.findById(id).get();
    }

    @Override
    public User save(User user) throws SQLException {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws SQLException {
        User user = repository.findById(id).get();
        repository.delete(user);
    }
}
