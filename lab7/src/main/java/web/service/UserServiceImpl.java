package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entity.User;
import web.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return repo.findById(username).orElse(null);
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public void delete(String username) {
        repo.deleteById(username);
    }
}
