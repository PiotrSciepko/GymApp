package pl.coderslab.gym.person;

import org.springframework.stereotype.Service;
import pl.coderslab.BCrypt;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPerson(long id) {
        Optional<Person> byId = personRepository.findById(id);
        return byId.orElse(null);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
