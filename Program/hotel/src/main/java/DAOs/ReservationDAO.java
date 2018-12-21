package DAOs;

import Config.Config;
import entities.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.List;

public class ReservationDAO {

    private SessionFactory sessionFactory = Config.sessionFactory;

    @Transactional
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

    @Transactional
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

    @Transactional
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

    @Transactional
    public Reservation findReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        Reservation newReservation;
        try {
            session.beginTransaction();
            newReservation =  session.get(Reservation.class, reservation.getId());
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return newReservation;
    }

    @Transactional
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