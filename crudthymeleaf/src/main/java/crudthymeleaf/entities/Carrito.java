package crudthymeleaf.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class Carrito {

	public List<Producto> listaproducto= new ArrayList<>();
	
	public float PagoTotal;
	
	public Carrito() {
		PagoTotal=0;
	}

	public float getPagoTotal() {
		return PagoTotal;
	}
	
	public void setPagoTotal(float pagoTotal) {
		PagoTotal = pagoTotal;
	}
		
	public float calcTotal() {
		for(int i=0;i<listaproducto.size();i++)
		{
			PagoTotal = PagoTotal + listaproducto.get(i).getPrecio();
		}
		return PagoTotal;
	}
	
	
	public void AddProductoCarrito(Producto add_producto) {
		listaproducto.add(add_producto);
		calcTotal();
	}
	
	
	public void RemoveProductoCarrito(Long BuscarId) {
		
		boolean Encontrado= false;
		Integer i=0;
		
		while(Encontrado==false && listaproducto.size()>i+1) {
			if(listaproducto.get(i).getId()==BuscarId) {
				listaproducto.remove(i);
				Encontrado = true;
			}
			else
			i=i+1;
		}
		if (Encontrado==true) {
			calcTotal();
		}		
	}
	
	
	
	
	
	
	
}
