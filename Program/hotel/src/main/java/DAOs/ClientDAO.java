package DAOs;

import Config.Config;
import entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientDAO {

    private SessionFactory sessionFactory = Config.sessionFactory;

    public Client addClient(Client client){
        Session session = sessionFactory.getCurrentSession();
        Client newClient = null;
        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            newClient = client;
        }
        finally {
            session.close();
        }
        return newClient;
    }

    public void removeClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.remove(client);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }

    public Client modifyClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        Client newClient = null;
        try {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
            newClient = client;
        }
        finally {
            session.close();
        }
        return newClient;
    }

    public Client findClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            client = session.get(Client.class, client);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return client;
    }

    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> clients;
        try {
            session.beginTransaction();
            clients = session.createQuery("SELECT res FROM Client res").getResultList();
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return clients;
    }
}