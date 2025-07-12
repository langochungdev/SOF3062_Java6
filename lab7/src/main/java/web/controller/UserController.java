package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.entity.User;
import web.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @GetMapping("{username}")
    public User getByUsername(@PathVariable("username") String username) {
        return userRepo.findById(username).orElse(null);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("{username}")
    public User update(@PathVariable("username") String username, @RequestBody User user) {
        if (!userRepo.existsById(username)) return null;
        return userRepo.save(user);
    }

    @DeleteMapping("{username}")
    public void delete(@PathVariable("username") String username) {
        userRepo.deleteById(username);
    }
}
