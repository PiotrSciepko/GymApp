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

    public boolean addPerson(Person person) {
        if (!personRepository.findByEmail(person.getEmail()).isEmpty()) {
            return false;
        }
        personRepository.save(person);
        return true;
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public boolean updatePerson(Person person) {
        Person byId = getPerson(person.getId());
        List<Person> byEmail = personRepository.findByEmail(person.getEmail());
        if (!byEmail.isEmpty()) {
            if (!byId.getEmail().equals(person.getEmail())) {
                return false;
            }
        }
        personRepository.save(person);
        return true;
    }

    public List<Person> getTrainers() {
        return personRepository.findByRole("trainer");
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
