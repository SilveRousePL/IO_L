package DAOs;

import Config.Config;
import entities.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RoomDAO {

    private SessionFactory sessionFactory = Config.sessionFactory;

    public Room addRoom(Room room){
        Session session = sessionFactory.getCurrentSession();
        Room newRoom;
        try {
            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();
            newRoom = room;
        }
        finally {
            session.close();
        }
        return room;
    }

    public void removeRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.remove(room);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }

    public Room modifyRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        Room newRoom;
        try {
            session.beginTransaction();
            session.update(room);
            session.getTransaction().commit();
            newRoom = room;
        }
        finally {
            session.close();
        }
        return newRoom;
    }

    public Room findRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        Room newRoom;
        try {
            session.beginTransaction();
            newRoom = session.get(Room.class, room);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return newRoom;
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
