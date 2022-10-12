package springboot.datajpa.app.services;

import springboot.datajpa.app.entities.Client;

import java.util.List;

public interface IClientService {

    public List<Client> findAll();

    public void save(Client client);
    public Client findClient(Long id);
    public void deleteClient(Long id);
}
