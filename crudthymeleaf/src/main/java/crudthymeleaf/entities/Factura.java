package crudthymeleaf.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Factura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToMany
	private List<Producto> producto;
	
	private Float TotalaPagar;
	

	public Factura(Long id, Cliente cliente, List<Producto> producto, Float totalaPagar) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		TotalaPagar = totalaPagar;
	}


	public Factura() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Float getTotalaPagar() {
		return TotalaPagar;
	}

	public void setTotalaPagar(Float totalaPagar) {
		TotalaPagar = totalaPagar;
	}
	
	
	
}
