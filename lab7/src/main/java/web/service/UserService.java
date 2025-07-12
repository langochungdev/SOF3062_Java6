package web.service;

import java.util.List;
import web.entity.User;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    User save(User user);
    void delete(String username);
}
