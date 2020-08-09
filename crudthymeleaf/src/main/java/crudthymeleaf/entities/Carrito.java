package crudthymeleaf.entities;

public class Carrito {

	Integer Num_Productos;
	Long Id_Productos;
	String nombres;
	String descripcion;
	float precio;
	int cantidad;
	float PagoTotal;
	
	public Integer getNum_Productos() {
		return Num_Productos;
	}
	
	public void setNum_Productos(Integer num_Productos) {
		Num_Productos = num_Productos;
	}
	
	public Long getId_Productos() {
		return Id_Productos;
	}
	
	public void setId_Productos(Long id_Productos) {
		Id_Productos = id_Productos;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getPagoTotal() {
		return PagoTotal;
	}
	
	public void setPagoTotal(float pagoTotal) {
		PagoTotal = pagoTotal;
	}
	
	
}
