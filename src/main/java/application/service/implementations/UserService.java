package application.service.implementations;


import application.entity.User;
import application.repository.UserRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements EntityService<User> {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAll() {
      return repository.findAll();
    }

    @Override
    public User getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }
}
