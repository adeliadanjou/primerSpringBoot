package com.spring.primerspringboot.services;

import java.util.List;

import com.spring.primerspringboot.models.Cliente;

public interface ClienteService {

	// TODOS LOS CLIENTES:
	public List<Cliente> getAllClients();
	// CLIENTE POR ID:
	public Cliente getOne(Integer id);
	// AÑADIR UN CLIENTE NUEVO:
	public Cliente create(Cliente cliente);
	// DELETE CLIENTE:
	public void delete(Integer id);
	// UPDATE CLIENTE:
//	public Cliente update();
}
