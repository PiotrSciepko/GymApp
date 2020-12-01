package pl.coderslab.gym.activity;

import lombok.*;
import pl.coderslab.gym.category.Category;
import pl.coderslab.gym.level.Level;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter

@Entity
@Table(name = "group_activities")

public class GroupActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Pole nie może byc puste")
    private String name;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Level level;
}
