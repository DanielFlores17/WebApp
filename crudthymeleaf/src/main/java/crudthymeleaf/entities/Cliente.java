package crudthymeleaf.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Cliente {
	
	@Id
	private String Email;
	
	@OneToMany(mappedBy="cliente")
	private List<Factura> factura;
	
	//@Column(name = "productos_nombre")
	private String Nombre;
	
	private String Apellido;
	
	private String Ciudad;
	
	private String Contrasena;
	
	private String Direccion;

	
	
	
	
	public Cliente(String email, List<Factura> factura, String nombre, String apellido, String ciudad,
			String contrasena, String direccion) {
		super();
		Email = email;
		this.factura = factura;
		Nombre = nombre;
		Apellido = apellido;
		Ciudad = ciudad;
		Contrasena = contrasena;
		Direccion = direccion;
	}
	
	

	public Cliente() {
		super();
	}



	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	
	
	
	
	
}
