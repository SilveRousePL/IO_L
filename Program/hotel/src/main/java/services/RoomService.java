package services;

import Config.Config;
import DAOs.RoomDAO;
import entities.Room;

import java.util.List;

public class RoomService {

    private RoomDAO roomDAO = Config.roomDAO;

    public Room addRoom(Room room){
        if(roomDAO.findRoom(room) == null)
            return roomDAO.addRoom(room);
        return room;
    }

    public void removeRoom(Room room) {
        if(roomDAO.findRoom(room)  != null)
            roomDAO.removeRoom(room);
    }

    public Room modifyRoom(Room room) {
        if(roomDAO.findRoom(room) == null)
            return roomDAO.addRoom(room);
        return roomDAO.modifyRoom(room);
    }

    public Room findRoom(Room room) {
        return roomDAO.findRoom(room);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }
}
