package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

@Service
public class DaoUserDetailsManager implements UserDetailsService {

    @Autowired
    UserDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findById(username).orElseThrow(() ->
            new UsernameNotFoundException("User not found"));

        String password = user.getPassword();
        String[] roles = user.getUserRoles().stream()
            .map(ur -> ur.getRole().getId().substring(5))
            .toArray(String[]::new);

        return org.springframework.security.core.userdetails.User 
            .withUsername(username)
            .password(password)
            .roles(roles)
            .build();
    }
}
