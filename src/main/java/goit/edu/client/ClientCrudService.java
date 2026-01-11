package goit.edu.client;

import goit.edu.exception.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientCrudService {
    SessionFactory factory;

    public ClientCrudService(SessionFactory factory) {
        this.factory = factory;
    }

    public Client getClientById(Long id) throws EntityNotFoundException {
        try (Session session = factory.openSession()) {
            Client client = session.find(Client.class, id);
            if (client == null) {
                throw new EntityNotFoundException("Client with id " + id + " not found");
            }
            return client;
        }
    }

    public List<Client> getAllClients() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

    public Client saveClient(Client client) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
        }
        return client;
    }

    public void updateClient(Long id, String newName) throws EntityNotFoundException {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Client client = session.find(Client.class, id);
            if (client == null) {
                throw new EntityNotFoundException("Client with id " + id + " not found");
            }
            client.setName(newName);
            session.getTransaction().commit();
        }
    }

    public void deleteClient(Long id) throws EntityNotFoundException {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Client client = session.find(Client.class, id);
            if (client == null) {
                throw new EntityNotFoundException("Client with id " + id + " not found");
            }
            session.remove(client);
            session.getTransaction().commit();
        }
    }
}
