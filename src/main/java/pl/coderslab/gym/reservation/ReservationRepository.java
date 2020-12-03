package pl.coderslab.gym.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.gym.activity.GroupActivity;

import java.util.ArrayList;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationsByDayAndHour(String day, String hour);
    List<Reservation> findReservationsByDayAndHourAndGroupActivity(String day, String hour, GroupActivity groupActivity);
}
