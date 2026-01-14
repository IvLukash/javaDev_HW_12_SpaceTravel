package goit.edu.client;

import goit.edu.exception.InvalidArgumentException;
import goit.edu.exception.NotFoundException;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    @Override
    public Client getClientById(Long id) throws NotFoundException {
        return clientDao.getById(id).orElseThrow(
                () -> new NotFoundException("Client with id " + id + " not found")
        );
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.getAll();
    }

    @Override
    public Client saveClient(String name) throws InvalidArgumentException {
        if (name == null || name.length() < 2 || name.length() > 200) {
            throw new InvalidArgumentException("Client name length should be between 2 and 200 symbols");
        }
        Client client = new Client(name);
        return clientDao.save(client);
    }

    @Override
    public void updateClient(Long id, String newName) throws NotFoundException, InvalidArgumentException {
        if (newName == null || newName.length() < 2 || newName.length() > 200) {
            throw new InvalidArgumentException("Client name length should be between 2 and 200 symbols");
        }
        Client client = getClientById(id);
        client.setName(newName);
        clientDao.update(client);
    }

    @Override
    public void deleteClient(Long id) throws NotFoundException {
        Client client = getClientById(id);
        clientDao.delete(client);
    }
}
