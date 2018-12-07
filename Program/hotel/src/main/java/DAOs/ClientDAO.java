package DAOs;

import Config.Config;
import entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientDAO {

    private SessionFactory sessionFactory = Config.sessionFactory;

    public boolean addClient(Client client){
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public boolean removeClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.remove(client);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public boolean modifyClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        boolean success;
        try {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
            success = true;
        }
        finally {
            session.close();
        }
        return success;
    }

    public Client findClient(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Client client;
        try {
            session.beginTransaction();
            client = session.get(Client.class, id);
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