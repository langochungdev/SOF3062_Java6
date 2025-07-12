package web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {
    @Id
    private String username;
    private String password;
    private String fullname;
    private Boolean enabled;
    private String role;
}
