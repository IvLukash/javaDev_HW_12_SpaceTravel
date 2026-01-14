package goit.edu.client;

import goit.edu.utils.SessionExecutor;

import java.util.List;
import java.util.Optional;

public class ClientDaoHibernateImpl implements ClientDao {
    private final SessionExecutor sessionExecutor;

    public ClientDaoHibernateImpl(SessionExecutor sessionExecutor) {
        this.sessionExecutor = sessionExecutor;
    }

    @Override
    public Optional<Client> getById(Long id) {
        return sessionExecutor.read(session ->
                Optional.ofNullable(session.find(Client.class, id)));
    }

    @Override
    public List<Client> getAll() {
        return sessionExecutor.read(session ->
                session.createQuery("from Client order by id", Client.class).list());
    }

    @Override
    public Client save(Client client) {
        return sessionExecutor.writeWithReturn(session -> {
           session.persist(client);
           return client;
        });
    }

    @Override
    public void update(Client client) {
        sessionExecutor.writeWithoutReturn(session ->
                session.merge(client));
    }

    @Override
    public void delete(Client client) {
        sessionExecutor.writeWithoutReturn(session ->
                session.remove(client));
    }
}