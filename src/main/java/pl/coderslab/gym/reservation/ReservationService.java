package pl.coderslab.gym.reservation;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        Collections.sort(reservations);
        return reservations;
    }

    public Reservation getReservation(long id) {
        Optional<Reservation> byId = reservationRepository.findById(id);
        return byId.orElse(null);
    }

    public boolean addReservation(Reservation reservation) {
        List<Reservation> byDayAndByHour = reservationRepository.
                findReservationsByDayAndHourAndGroupActivity(reservation.getDay(), reservation.getHour(), reservation.getGroupActivity());
        if (!byDayAndByHour.isEmpty()) {
            return false;
        }
        reservationRepository.save(reservation);
        return true;
    }

    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }

    public boolean updateReservation(Reservation reservation) {
        Reservation byId = getReservation(reservation.getId());
        List<Reservation> byDayAndHourAndActivity = reservationRepository.
                findReservationsByDayAndHourAndGroupActivity(reservation.getDay(), reservation.getHour(), reservation.getGroupActivity());
        if (!byDayAndHourAndActivity.isEmpty()) {
            if (byId.getReservationTrainers().equals(reservation.getReservationTrainers())) {
                return false;
            }
        }
        reservationRepository.save(reservation);
        return true;
    }
}
