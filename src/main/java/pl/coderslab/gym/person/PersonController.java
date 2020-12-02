package pl.coderslab.gym.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        return "/person/list";
    }

    @GetMapping("/show/{id}")
    public String showPerson(@PathVariable long id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "/person/show";
    }

    @GetMapping("/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "/person/add";
    }

    @PostMapping("/add")
    public String addPerson(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/person/add";
        }
        if (personService.addPerson(person)) {
            person.setPassword(personService.hashPassword(person.getPassword()));
            personService.addPerson(person);
            return "redirect:/person/list";
        }
        model.addAttribute("error", "Taki email już istnieje");
        return "/person/add";
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
        return "/person/edit";
    }

    @PostMapping("/update")
    public String updatePerson(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/person/edit";
        } else if (personService.updatePerson(person)) {
            person.setPassword(personService.hashPassword(person.getPassword()));
            personService.updatePerson(person);
            return "redirect:/person/list";
        }
        model.addAttribute("error", "Taki email już istnieje");
        return "/person/edit";
    }
}
