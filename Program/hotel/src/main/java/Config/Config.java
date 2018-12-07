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

    private static SessionFactory sessionFactory() {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    public static final SessionFactory sessionFactory =  sessionFactory();

    public static final ReservationDAO reservationDAO = new ReservationDAO();
    public static final ReservationService reservationService = new ReservationService();

    public static final ClientDAO clientDAO = new ClientDAO();
    public static final ClientService clientService = new ClientService();

    public static final RoomDAO roomDAO = new RoomDAO();
    public static final RoomService roomService = new RoomService();
}
