package pl.coderslab.gym.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gym.activity.ActivityService;
import pl.coderslab.gym.activity.GroupActivity;
import pl.coderslab.gym.person.Person;
import pl.coderslab.gym.person.PersonService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final ActivityService activityService;
    private final PersonService personService;

    public ReservationController(ReservationService reservationService, ActivityService activityService,
                                 PersonService personService) {
        this.reservationService = reservationService;
        this.activityService = activityService;
        this.personService = personService;
    }

    @GetMapping("/list")
    public String reservationList(Model model) {
        model.addAttribute("reservations", reservationService.getReservations());
        return "/reservation/list";
    }

    @GetMapping("/show/{id}")
    public String showReservation(@PathVariable long id, Model model) {
        Reservation reservation = reservationService.getReservation(id);
        model.addAttribute("reservation", reservation);
        return "/reservation/show";
    }

    @GetMapping("/add")
    public String addReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "/reservation/add";
    }

    @PostMapping("/add")
    public String addReservation(Reservation reservation, Model model) {
        if (reservationService.addReservation(reservation)) {
            return "redirect:/reservation/list";
        }
        model.addAttribute("error", "Błąd: Zajęcia o tej porze już istnieją!");
        return "/reservation/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservation/list";
    }

    @GetMapping("/update/{id}")
    public String updateReservation(@PathVariable long id, Model model) {
        model.addAttribute("reservation", reservationService.getReservation(id));
        return "/reservation/edit";
    }

    @PostMapping("/update")
    public String updateReservation(Reservation reservation, Model model) {
        if (reservationService.updateReservation(reservation)){
            return "redirect:/reservation/list";
        }
        model.addAttribute("error", "Błąd: Zajęcia o tej porze już istnieją!");
        return "/reservation/edit";
    }

    @ModelAttribute("days")
    public Collection<String> days() {
        return List.of("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela");
    }

    @ModelAttribute("hours")
    public Collection<String> hours() {
        List<String> hours = new ArrayList<>();
        for (int i = 6; i < 22; i++) {
            hours.add(String.valueOf(i));
        }
        return hours;
    }

    @ModelAttribute("activities")
    public Collection<GroupActivity> activities() {
        return this.activityService.getActivities();
    }

    @ModelAttribute("trainers")
    public Collection<Person> trainers() {
        return this.personService.getTrainers();
    }
}
