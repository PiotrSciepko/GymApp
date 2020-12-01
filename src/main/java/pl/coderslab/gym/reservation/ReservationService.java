package pl.coderslab.gym.reservation;

import org.springframework.stereotype.Service;
import pl.coderslab.gym.person.Person;

import java.util.ArrayList;
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

    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }

    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
