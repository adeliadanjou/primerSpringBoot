package com.spring.primerspringboot.controllers;

import java.util.List;
import javax.validation.Valid;
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
import com.spring.primerspringboot.models.Factura;
import com.spring.primerspringboot.services.FacturaServiceImpl;

@RestController
@RequestMapping(path = "/facturas")
public class FacturaController {

	  @Autowired
	  private FacturaServiceImpl facturaService;
		
	    // LISTA TODOS LOS CLIENTES
		@GetMapping()
		public List<Factura> getAll(){
			return facturaService.getAllFacturas();
		}
	    // DATOS DE 1 CLIENTE
		@GetMapping("/{factura_id}")
		public Factura getOne(@PathVariable Integer factura_id){
			return facturaService.getOne(factura_id);
		}
		
		
		// CREA FACTURAS O LAS MODIFICA SI VIENE CON ID
		@PostMapping("/create")
		public ResponseEntity<Factura> saveFactura(@RequestBody @Valid Factura factura){
			
			return new ResponseEntity<Factura>(facturaService.create(factura), HttpStatus.OK);
			
		}
		
		// DELETE FACTURAS
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteFactura(@PathVariable Integer id){
			
			facturaService.delete(id);
			return new ResponseEntity<String>("Factura borrada", HttpStatus.OK);
		}
		
		

		
}
