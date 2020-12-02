package pl.coderslab.gym.person;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByRole(String role);
    List<Person> findByEmail(String email);
}
