package services;

import Config.Config;
import DAOs.RoomDAO;
import entities.Room;

import java.util.List;

public class RoomService {

    private RoomDAO roomDAO = Config.roomDAO;

    public boolean addRoom(Room room){
        return roomDAO.addRoom(room);
    }

    public boolean removeRoom(Room room) {
        return roomDAO.removeRoom(room);
    }

    public boolean modifyRoom(Room room) {
        return roomDAO.modifyRoom(room);
    }

    public Room findRoom(Long id) {
        return roomDAO.findRoom(id);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }
}
