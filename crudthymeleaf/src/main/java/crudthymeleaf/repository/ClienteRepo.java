package crudthymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import crudthymeleaf.entities.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, String>{

}
