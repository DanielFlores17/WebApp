package crudthymeleaf.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import crudthymeleaf.entities.Cliente;
import crudthymeleaf.entities.Producto;

@Entity
@Table
public class Factura {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	/*@JoinColumn(name="ID_Producto")
	@ManyToMany(cascade = CascadeType.ALL)		//Relación a producto
	private Producto producto;
	
	@JoinColumn(name="Email")
	@ManyToOne(cascade = CascadeType.ALL)		//Relación a cliente
	private Cliente cliente;*/
	
	//Faltaría la cantidad de poductos similares
	private float TotalaPagar;
	

	/*public Factura (Producto producto, Cliente cliente) {
		this.producto=producto;
		this.cliente=cliente;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}*/
	
	public float getTotalaPagar() {
		return TotalaPagar;
	}

	public void setTotalaPagar(float totalaPagar) {
		TotalaPagar = totalaPagar;
	}
	
	
}
