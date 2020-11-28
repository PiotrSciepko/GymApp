package pl.coderslab.gym.activity;

import lombok.*;
import pl.coderslab.gym.category.Category;
import pl.coderslab.gym.level.Level;
import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "group_activities")

public class GroupActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Level level;
}
