package web.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Categories")
public class Category {
    @Id
    private Integer id;
    private String name;
}
