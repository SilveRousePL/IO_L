package DAOs;

import Config.Config;
import entities.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RoomDAO {

    private SessionFactory sessionFactory = Config.sessionFactory;

    public boolean addRoom(Room room){
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public boolean removeRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.remove(room);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public boolean modifyRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.update(room);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public Room findRoom(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Room room;
        try {
            session.beginTransaction();
            room = session.get(Room.class, id);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return room;
    }

    public List<Room> getAllRooms() {
        Session session = sessionFactory.getCurrentSession();
        List<Room> rooms;
        try {
            session.beginTransaction();
            rooms = session.createQuery("SELECT res FROM Room res").getResultList();
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return rooms;
    }
}
