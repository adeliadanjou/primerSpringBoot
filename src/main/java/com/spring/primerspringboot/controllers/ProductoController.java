package com.spring.primerspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.primerspringboot.models.Producto;
import com.spring.primerspringboot.services.ProductoServiceImpl;

@RestController
@RequestMapping(path = "/productos")
public class ProductoController {
	
	@Autowired
	public ProductoServiceImpl productoService;
	
	  // LISTA TODOS LOS PRODUCTOS:
	
	@GetMapping()
	public List<Producto> getAll(){
		return productoService.getAllProductos();
	}
	
    // DATOS DE 1 PRODUCTO
	@GetMapping("/{producto_id}")
	public Producto getOne(@PathVariable Integer producto_id){
		return productoService.getOne(producto_id);
	}
	
	// CREA PRODUCTOS O LOS MODIFICA SI VIENE CON ID:
	@PostMapping("/create")
	public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto){
		return new ResponseEntity<Producto>(productoService.create(producto), HttpStatus.OK);
	}
	
	// DELETE PRODUCTOS:
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProducto(@PathVariable Integer id){
		
		productoService.delete(id);
		return new ResponseEntity<String>("Producto borrado", HttpStatus.OK);
	}
	

}
