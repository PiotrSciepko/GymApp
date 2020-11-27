package pl.coderslab.gym;

import pl.coderslab.gym.activity.GroupActivity;
import pl.coderslab.gym.person.Person;

import javax.persistence.*;
import java.util.List;

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
}
