package web.entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Products")
public class Product {
    @Id
    private Integer id;
    private String name;
    private Double price;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
