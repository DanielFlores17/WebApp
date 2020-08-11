package crudthymeleaf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import crudthymeleaf.entities.Carrito;
import crudthymeleaf.entities.Cliente;
import crudthymeleaf.entities.Producto;
import crudthymeleaf.repository.FacturaRepo;
import crudthymeleaf.repository.ProductoRepo;
import crudthymeleaf.service.PictureService;

@Controller
@RequestMapping("/productos")
public class ProductoControlador {

 

     @Autowired
     private ProductoRepo productorepo;
     
     
     /*@Autowired
     private FacturaRepo facturarepo;
     
     @Autowired
     private Cliente clienterepo;*/
     
     @Autowired
        PictureService picService;
     
     
     @RequestMapping("")
     public String index() {
        return "index";
     }
     
     
     
 	 Long id;
 	 Producto producto;
 	 Carrito carrito;
     
     
     @GetMapping("/add_product")
     public String showSignUpForm(Producto producto) {
         return "add_product";
     }
 
     @GetMapping("/list")
     public String showProducts(Model model) {
         model.addAttribute("products", productorepo.findAll());
         return "list_products";
     }
     
     @GetMapping("/about")
	 public String showAbout() {
	     return "about_us";
	 }	
     
     @GetMapping("/carrito")
     public String showSignUpForm() {
         return "carrito";
     }
     
     
     
     //aqui
     @GetMapping("/add_carrito")
     public String showProducts(HttpServletRequest resquest) {
    	 	id =  Long.parseLong(resquest.getParameter("id"));
    	 	System.out.println(id);
			producto = productorepo.findById(id).orElseThrow( () -> new IllegalArgumentException("invalid product id: "+id));;
			carrito.AddProductoCarrito(producto);
			return null;
     }
     
     
     @GetMapping("/delete_carrito")		
 	public void DeleteProductoCarrito(HttpServletRequest request) throws ServletException, IOException 
 	{
    	 Long BuscarId= Long.parseLong(request.getParameter("buscarid"));
    	 carrito.RemoveProductoCarrito(BuscarId);
 	}
     
     
     
     
     
     @RequestMapping("/login")
     public String showLogin() {
         return "login";
     }
     
     @GetMapping("/sc")
     public String showProducts() {
         return "soundcloud.html";
     }     
     
     @PreAuthorize("hasAuthority('admin')")
     @RequestMapping("/private")
     public String showPrivate(Model model) {
         model.addAttribute("products", productorepo.findAll());
         return "list_products";
     }
     
     @PreAuthorize("hasAuthority('admin')")
     @PostMapping("/add")
     public String addProduct(Producto producto, BindingResult result, Model model, @RequestParam("file") MultipartFile file) {
         if (result.hasErrors()) { 
            return "add_product";
         }
         UUID idPic = UUID.randomUUID();
         picService.uploadPicture(file, idPic);
         producto.setFoto(idPic);
         productorepo.save(producto);   
         return "redirect:list";
     }

 

     @PreAuthorize("hasAuthority('admin')")
     @GetMapping("/edit/{id}")
     public String showUpdateForm(@PathVariable("id") Long id, Model model) {
         Producto producto = productorepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + id));
         model.addAttribute("product", producto);
         return "update_product";
     }
     
     @PreAuthorize("hasAuthority('admin')")
     @PostMapping("/update/{id}")
     public String updateProduct(@PathVariable("id") Long id, Producto producto, BindingResult result, Model model, @RequestParam("file") MultipartFile file) {
         if (result.hasErrors()) {
              producto.setId(id);
              return "update_product";
         }
         
         if (!file.isEmpty()) {
             picService.deletePicture(producto.getFoto());
             UUID idPic = UUID.randomUUID();
             picService.uploadPicture(file, idPic);
             producto.setFoto(idPic);
         }
         productorepo.save(producto);
         return "redirect:/productos/list";
     }

 

     @PreAuthorize("hasAuthority('admin')")
     @GetMapping("/delete/{id}")
     public String deleteProduct(@PathVariable("id") Long id, Model model) {
         Producto producto = productorepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
         picService.deletePicture(producto.getFoto());
         productorepo.delete(producto);         
         model.addAttribute("products", productorepo.findAll());
         return "list_products";
     }
}
