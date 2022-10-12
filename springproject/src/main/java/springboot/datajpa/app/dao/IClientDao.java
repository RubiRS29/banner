package springboot.datajpa.app.dao;

import org.springframework.data.repository.CrudRepository;
import springboot.datajpa.app.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientDao extends CrudRepository<Client, Long> {


}
