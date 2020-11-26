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

    @PostMapping("/show")
    public String showPerson(@RequestParam long personId, @RequestParam String personName, @RequestParam String personEmail,
                             @RequestParam String personRole, Model model) {
        Person person = new Person(personId, personEmail, personName, personRole);
        model.addAttribute("person", person);
        return "/person/show.jsp";
    }

    @GetMapping("/add")
    public String addNewPerson() {
        return "/person/add.jsp";
    }

    @PostMapping("/add")
    public String addPerson(@RequestParam String personName, @RequestParam String personEmail, @RequestParam String personPassword,
                            @RequestParam String personRole) {
        Person person = new Person(personEmail, personName, personService.hashPassword(personPassword), personRole);
        personService.addPerson(person);
        return "redirect:/person/list";
    }

    @PostMapping("/delete")
    public String deletePerson(@RequestParam long personId) {
        personService.deletePerson(personId);
        return "redirect:/person/list";
    }

    @PostMapping("/update")
    public String updatePerson(@RequestParam long personId, @RequestParam String personName, @RequestParam String personEmail,
                               @RequestParam String personPassword, @RequestParam String personRole) {
        Person person = new Person(personId, personEmail, personName, personService.hashPassword(personPassword), personRole);
        personService.updatePerson(person);
        return "redirect:/person/list";
    }
}
