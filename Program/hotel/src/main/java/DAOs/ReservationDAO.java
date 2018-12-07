package DAOs;

import Config.Config;
import entities.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReservationDAO {

    private SessionFactory sessionFactory = Config.sessionFactory;

    public boolean addReservation(Reservation reservation){
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.save(reservation);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public boolean removeReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.remove(reservation);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public boolean modifyReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.update(reservation);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public Reservation findReservation(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Reservation reservation;
        try {
            session.beginTransaction();
            reservation = session.get(Reservation.class, id);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return reservation;
    }

    public List<Reservation> getAllReservation() {
        Session session = sessionFactory.getCurrentSession();
        List<Reservation> reservations;
        try {
            session.beginTransaction();
            reservations = session.createQuery("SELECT res FROM Reservation res").getResultList();
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return reservations;
    }
}
