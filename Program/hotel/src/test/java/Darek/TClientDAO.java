package Darek;

import entities.Client;
import entities.Room;

public class TClientDAO {
    public Client addClient(Client client) {
        Client newClient = new Client();

        if(client == null) {
            return null;
        }
        if(client.getFirstName() == null || client.getFirstName() == "") {
            return null;
        }
        if(client.getLastName() == null || client.getLastName() == "") {
            return null;
        }
        if(client.getPesel() == null || client.getPesel() == "") {
            return null;
        }
        if(client.getPhoneNumber() == null || client.getPhoneNumber() == "") {
            return null;
        }
        /*if(client.getId() == null) {

        }*/
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());
        newClient.setPesel(client.getPesel());
        newClient.setPhoneNumber(client.getPhoneNumber());
        return newClient;
    }

    public Client addRoom(Room room) {

    }
}
