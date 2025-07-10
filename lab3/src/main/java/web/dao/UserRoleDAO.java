package web.dao;
import web.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {}
