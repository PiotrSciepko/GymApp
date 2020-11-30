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

    public ReservationController(ReservationService reservationService, ActivityService activityService, PersonService personService) {
        this.reservationService = reservationService;
        this.activityService = activityService;
        this.personService = personService;
    }

    @GetMapping("/list")
    public String reservationList(Model model) {
        model.addAttribute("reservations", reservationService.getReservations());
        return "/reservation/list.jsp";
    }

    @GetMapping("/show/{id}")
    public String showReservation(@PathVariable long id, Model model) {
        Reservation reservation = reservationService.getReservation(id);
        model.addAttribute("reservation", reservation);
        return "/reservation/show.jsp";
    }

    @GetMapping("/add")
    public String addReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "/reservation/add.jsp";
    }

    @PostMapping("/add")
    public String addReservation(Reservation reservation) {
        reservationService.addReservation(reservation);
        return "redirect:/reservation/list";
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
