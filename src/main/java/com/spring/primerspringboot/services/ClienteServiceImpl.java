package com.spring.primerspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.primerspringboot.models.Cliente;
import com.spring.primerspringboot.repositories.ClientesRepository;

@Component
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClientesRepository clienteRepository;
	
	@Override
	public List<Cliente> getAllClients() {
		
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	@Override
	public Cliente getOne(Integer id) {
		
		Optional<Cliente> optional = clienteRepository.findById(id);		
		
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public Cliente create(Cliente cliente) {
	
		return clienteRepository.save(cliente);
	}

	@Override
	public void delete(Integer id) {
		
		 clienteRepository.deleteById(id);
	}


	
	

}
