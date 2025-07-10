package web.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserRoles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    User user;

    @ManyToOne
    @JoinColumn(name = "roleid")
    Role role;
}
