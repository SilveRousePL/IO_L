package services;

import Config.Config;
import DAOs.ClientDAO;
import entities.Client;

import java.util.List;

public class ClientService {

    private ClientDAO clientDAO = Config.clientDAO;

    public boolean addClient(Client client){
        return clientDAO.addClient(client);
    }

    public boolean removeClient(Client client) {
        return clientDAO.removeClient(client);
    }

    public boolean modifyClient(Client client) {
        return clientDAO.modifyClient(client);
    }

    public Client findClient(Long id) {
        return clientDAO.findClient(id);
    }

    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }
}
