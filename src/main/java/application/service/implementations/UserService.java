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
    public List<User> getAll() throws Throwable {
      return repository.findAll();
    }

    @Override
    public User getById(int id) throws Throwable {
        return repository.findById(id).get();
    }

    @Override
    public void save(User user) throws Throwable {
        repository.save(user);
    }

    @Override
    public void delete(int id) throws Throwable {
        repository.delete(repository.findById(id).get());
    }
}
