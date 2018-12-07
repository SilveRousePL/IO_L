package Config;

import DAOs.ClientDAO;
import DAOs.ReservationDAO;
import DAOs.RoomDAO;
import entities.Client;
import entities.Reservation;
import entities.Room;
import org.hibernate.SessionFactory;
import services.ClientService;
import services.ReservationService;
import services.RoomService;

public class Config {

    public static SessionFactory sessionFactory() {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory sessionFactory =  sessionFactory();

    public static ReservationDAO reservationDAO = new ReservationDAO();
    public static ReservationService reservationService = new ReservationService();

    public static ClientDAO clientDAO = new ClientDAO();
    public static ClientService clientService = new ClientService();

    public static RoomDAO roomDAO = new RoomDAO();
    public static RoomService roomService = new RoomService();
}
