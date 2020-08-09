package crudthymeleaf.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import crudthymeleaf.entities.Producto;

public interface ProductoRepo extends CrudRepository <Producto, Long>{

    List<Producto> findByNombre(String Nombre); 
    
    //List<Producto> findByPreparacion(String preparacion);
}