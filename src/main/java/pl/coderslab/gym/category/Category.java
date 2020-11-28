package pl.coderslab.gym.category;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "categories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
