package pl.coderslab.gym.person;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String email;

    private String name;
    private String password;
    private String role;

    public Person(String email, String name, String password, String role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
