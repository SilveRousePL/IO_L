package services;

import Config.Config;
import DAOs.ReservationDAO;
import entities.Reservation;

import java.util.List;

public class ReservationService {

    private ReservationDAO reservationDAO = Config.reservationDAO;

    public boolean addReservation(Reservation reservation){
        return reservationDAO.addReservation(reservation);
    }

    public boolean removeReservation(Reservation reservation) {
        return reservationDAO.removeReservation(reservation);
    }

    public boolean modifyReservation(Reservation reservation) {
        return reservationDAO.modifyReservation(reservation);
    }

    public Reservation findReservation(Long id) {
        return reservationDAO.findReservation(id);
    }

    public List<Reservation> getAllReservation() {
        return reservationDAO.getAllReservation();
    }
}
