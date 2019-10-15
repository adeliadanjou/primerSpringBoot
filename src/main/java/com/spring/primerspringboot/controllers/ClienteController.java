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

import com.spring.primerspringboot.models.Cliente;
import com.spring.primerspringboot.services.ClienteServiceImpl;


@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	
  @Autowired
  private ClienteServiceImpl clienteService;
	
    // LISTA TODOS LOS CLIENTES
	@GetMapping()
	public List<Cliente> getAll(){
		return clienteService.getAllClients();
	}
    // DATOS DE 1 CLIENTE
	@GetMapping("/{client_id}")
	public Cliente getOne(@PathVariable Integer client_id){
		return clienteService.getOne(client_id);
	}
	
	
	
	// CREA CLIENTES O LOS MODIFICA SI VIENE CON ID
	@PostMapping("/create")
	public ResponseEntity<Cliente> saveCliente(@RequestBody @Valid Cliente cliente){
		
		return new ResponseEntity<Cliente>(clienteService.create(cliente), HttpStatus.OK);
		
		/*
		 * if (clienteService.create(cliente) != null) {
			return new ResponseEntity<Cliente>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 */
	}
	
	// DELETE CLIENTES
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable Integer id){
		
		clienteService.delete(id);
		return new ResponseEntity<String>("Registro borrado", HttpStatus.OK);
	}
	
	

	
	

  

}
