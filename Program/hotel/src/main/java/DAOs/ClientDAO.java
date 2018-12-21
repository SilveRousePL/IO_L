package DAOs;

import Config.Config;
import entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.List;

public class ClientDAO {

    private SessionFactory sessionFactory = Config.sessionFactory;

    @Transactional
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

    @Transactional
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

    @Transactional
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

    @Transactional
    public Client findClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        List<Client> results;
        try {
            session.beginTransaction();
            Query query = session.createQuery("SELECT C FROM Client C WHERE ( C.firstName = :first_name AND C.lastName = :last_name )");
            query.setParameter("first_name", client.getFirstName());
            query.setParameter("last_name", client.getLastName());
            results = query.list();
        }
        finally {
            session.close();
        }
        if(results != null && results.size() > 0)
            return results.get(0);
        return null;
    }

    @Transactional
    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> clients;
        try {
            session.beginTransaction();
            clients = session.createQuery("SELECT res FROM Client res").getResultList();
        }
        finally {
            session.close();
        }
        return clients;
    }
}