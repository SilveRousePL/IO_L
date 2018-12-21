package DAOs;

import Config.Config;
import entities.Client;
import entities.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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
        List<Room> results;
        try {
            session.beginTransaction();
            Query query = session.createQuery("SELECT R FROM Room R WHERE R.roomNumber = :room_number");
            query.setParameter("room_number", room.getRoomNumber());
            results = query.list();
        }
        finally {
            session.close();
        }
        if(results != null && results.size() > 0)
            return results.get(0);
        return null;
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