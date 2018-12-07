package DAOs;

import Config.Config;
import entities.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReservationDAO {

    private SessionFactory sessionFactory = Config.sessionFactory;

    public Reservation addReservation(Reservation reservation){
        Session session = sessionFactory.getCurrentSession();
        Reservation newReservation1 = null;
        try {
            session.beginTransaction();
            session.save(reservation);
            session.getTransaction().commit();
            newReservation1 = reservation;
        }
        finally {
            session.close();
        }
        return newReservation1;
    }

    public void removeReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.remove(reservation);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }

    public Reservation modifyReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        Reservation newReservation = null;
        try {
            session.beginTransaction();
            session.update(reservation);
            session.getTransaction().commit();
            newReservation = reservation;
        }
        finally {
            session.close();
        }
        return newReservation;
    }

    public Reservation findReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        Reservation newReservation;
        try {
            session.beginTransaction();
            newReservation = session.get(Reservation.class, reservation);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return newReservation;
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
