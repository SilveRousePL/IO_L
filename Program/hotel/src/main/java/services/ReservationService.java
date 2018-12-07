package services;

import Config.Config;
import DAOs.ReservationDAO;
import entities.Reservation;

import java.util.List;

public class ReservationService {

    private ReservationDAO reservationDAO = Config.reservationDAO;

    public Reservation addReservation(Reservation reservation){
        if(reservationDAO.findReservation(reservation) != null)
            return reservation;
        return reservationDAO.addReservation(reservation);
    }

    public void removeReservation(Reservation reservation) {
        if(reservationDAO.findReservation(reservation) != null)
            reservationDAO.removeReservation(reservation);
    }

    public Reservation modifyReservation(Reservation reservation) {
        if(reservationDAO.findReservation(reservation) == null)
            reservationDAO.addReservation(reservation);
        return reservationDAO.modifyReservation(reservation);
    }

    public Reservation findReservation(Reservation reservation) {
        return reservationDAO.findReservation(reservation);
    }

    public List<Reservation> getAllReservation() {
        return reservationDAO.getAllReservation();
    }
}
