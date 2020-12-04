package pl.coderslab.gym.person;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
    @Email(message = "Niepoprawny email")
//    @Pattern(regexp = "^[a-zA-Z]*(\\.*[a-zA-Z]+[a-zA-Z0-9_])+@[a-zA-Z]*(\\.*[a-zA-Z]+[a-zA-Z0-9_])+")
    private String email;

    @NotBlank(message = "Pole nie może być puste")
    private String name;

    @NotBlank(message = "Pole nie może być puste")
    private String password;
    private String role;

}
