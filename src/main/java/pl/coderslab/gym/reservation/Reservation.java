package pl.coderslab.gym.reservation;

import lombok.Data;
import pl.coderslab.gym.activity.GroupActivity;
import pl.coderslab.gym.person.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@Table(name="reservations")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String week;
    private String day;
    private String hour;

    @ManyToMany
    private List<Person> persons;

    @ManyToOne
    private GroupActivity groupActivity;

    public List<String> getReservationTrainers() {
        List<String> reservationTrainers = new ArrayList<>();
        for (Person person : getPersons()) {
            String role = person.getRole();
            if (role.equals("trainer")) {
                reservationTrainers.add(person.getName());
            }
        }
        return reservationTrainers;
    }


}
