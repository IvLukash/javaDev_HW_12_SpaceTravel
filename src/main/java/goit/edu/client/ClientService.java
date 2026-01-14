package goit.edu.client;

import goit.edu.exception.InvalidArgumentException;
import goit.edu.exception.NotFoundException;

import java.util.List;

public interface ClientService {
    Client getClientById(Long id)  throws NotFoundException;
    List<Client> getAllClients();
    Client saveClient(String name) throws InvalidArgumentException;
    void updateClient(Long id, String newName) throws NotFoundException, InvalidArgumentException;
    void deleteClient(Long id) throws NotFoundException;
}
