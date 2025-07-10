package web.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "Roles")
public class Role {

    @Id
    String id;

    String name;

    @OneToMany(mappedBy = "role")
    List<UserRole> userRoles;
}
