package crudthymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import crudthymeleaf.entities.Factura;

import java.util.List;


public interface FacturaRepo extends CrudRepository <Factura,Long> {
	List <Factura> findByID(Long id);
}
