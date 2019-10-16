package com.spring.primerspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.primerspringboot.models.Cliente;
import com.spring.primerspringboot.models.Producto;
import com.spring.primerspringboot.repositories.ClientesRepository;
import com.spring.primerspringboot.repositories.ProductoRepository;

@Component
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	
	@Override
	public List<Producto> getAllProductos() {
		
		return (List<Producto>) productoRepository.findAll();
	}
	
	@Override
	public Producto getOne(Integer id) {
		
		Optional<Producto> optional = productoRepository.findById(id);		
		
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public Producto create(Producto producto) {
	
		return productoRepository.save(producto);
	}

	@Override
	public void delete(Integer id) {
		
		 productoRepository.deleteById(id);
	}



	
	

}
