package pl.coderslab.gym.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByRole(String role);
}
