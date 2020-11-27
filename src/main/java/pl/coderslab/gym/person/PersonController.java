package pl.coderslab.gym.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public String personList(Model model) {
        model.addAttribute("persons", personService.getPersons());
        return "/person/list.jsp";
    }

    @GetMapping("/show/{id}")
    public String showPerson(@PathVariable long id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "/person/show.jsp";
    }

    @GetMapping("/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "/person/add.jsp";
    }

    @PostMapping("/add")
    public String addPerson(Person person) {
        person.setPassword(personService.hashPassword(person.getPassword()));
        personService.addPerson(person);
        return "redirect:/person/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable long id) {
        personService.deletePerson(id);
        return "redirect:/person/list";
    }

    @GetMapping("/update/{id}")
    public String updatePerson(@PathVariable long id, Model model) {
        Person person = personService.getPerson(id);
        person.setPassword("");
        model.addAttribute("person", person);
        return "/person/edit.jsp";
    }

    @PostMapping("/update")
    public String updatePerson(Person person) {
        person.setPassword(personService.hashPassword(person.getPassword()));
        personService.updatePerson(person);
        return "redirect:/person/list";
    }
}
