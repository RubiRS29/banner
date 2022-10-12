package springboot.datajpa.app.services;

import org.springframework.stereotype.Service;
import springboot.datajpa.app.dao.IClientDao;
import springboot.datajpa.app.entities.Client;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    private final IClientDao clientDao;

    public ClientServiceImpl(IClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientDao.findAll();
    }

    @Override
    public Client findClient(Long id) {
        return clientDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientDao.save(client);
    }


    @Override
    @Transactional
    public void deleteClient(Long id) {
        clientDao.deleteById(id);
    }
}
