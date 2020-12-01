package pl.coderslab.gym.level;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "levels")

public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Pole nie może być puste")
    private String name;
}
