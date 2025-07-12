package b4.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Students")
public class Student {
    @Id
    String id;
    String name;
    boolean gender;
    double mark;
}
