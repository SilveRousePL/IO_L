package Wojtek;

import entities.Client;

public class ClientTDao {

    public Client modifyClient(Client client) {

        if (client == null) {
            return null;
        }

        if (client.getFirstName() == null || client.getFirstName() == "") {
            return null;
        }

        if (client.getLastName() == null || client.getLastName() == "") {
            return null;
        }

        Client newClient = new Client();
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());
        newClient.setPesel(client.getPesel());
        newClient.setPhoneNumber(client.getPhoneNumber());
        return newClient;
    }
}
