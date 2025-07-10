package web.model;
import lombok.Data;
import java.util.List;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    String username;

    String password;

    boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<UserRole> userRoles;
}
