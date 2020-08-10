package crudthymeleaf.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table//(name = "productos")
public class Producto {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(mappedBy="producto")
	private List<Factura> factura;
	
	
	//@Column(name = "productos_nombre")
	private String nombre;
	
	private UUID foto;
	
	private String descripcion;

	private Integer cantidad;
	
	private Float precio;

	
	
	public Producto() {
		super();
	}

	public Producto(Long id, List<Factura> factura, String nombre, UUID foto, String descripcion, Integer cantidad,
			Float precio) {
		super();
		this.id = id;
		this.factura = factura;
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public UUID getFoto() {
		return foto;
	}

	public void setFoto(UUID foto) {
		this.foto = foto;
	}	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Float getPrecio() {
		return precio;
	}
	
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

}
