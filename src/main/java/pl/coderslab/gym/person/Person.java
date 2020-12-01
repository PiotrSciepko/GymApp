package pl.coderslab.gym.person;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotBlank(message = "Pole nie może być puste")
    private String email;

    @NotBlank(message = "Pole nie może być puste")
    private String name;

    @NotBlank(message = "Pole nie może być puste")
    private String password;
    private String role;

}
