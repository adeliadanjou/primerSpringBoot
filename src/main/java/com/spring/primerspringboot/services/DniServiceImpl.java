package com.spring.primerspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.primerspringboot.models.Cliente;
import com.spring.primerspringboot.models.Dni;
import com.spring.primerspringboot.models.Producto;
import com.spring.primerspringboot.repositories.ClientesRepository;
import com.spring.primerspringboot.repositories.DniRepository;
import com.spring.primerspringboot.repositories.ProductoRepository;

@Component
public class DniServiceImpl implements DniService {

	@Autowired
	private DniRepository dniRepository;

	
	@Override
	public List<Dni> getAllDnis() {
		
		return (List<Dni>) dniRepository.findAll();
	}
	

	@Override
	public Dni create(Dni dni) {
	
		return dniRepository.save(dni);
	}




	
	

}
