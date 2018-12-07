package services;

import Config.Config;
import DAOs.ClientDAO;
import entities.Client;

import java.util.List;

public class ClientService {

    private ClientDAO clientDAO = Config.clientDAO;

    public Client addClient(Client client){
        if(clientDAO.findClient(client) == null)
            return clientDAO.addClient(client);
        return client;
    }

    public void removeClient(Client client) {
        if(clientDAO.findClient(client) != null)
            clientDAO.removeClient(client);
    }

    public Client modifyClient(Client client) {
        if(clientDAO.findClient(client) == null)
            return clientDAO.addClient(client);
        return clientDAO.modifyClient(client);
    }

    public Client findClient(Client client) {
        return clientDAO.findClient(client);
    }

    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }
}
