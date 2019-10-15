package com.spring.primerspringboot.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.primerspringboot.models.Factura;
import com.spring.primerspringboot.repositories.FacturaRepository;

public class FacturaServiceImpl implements FacturaService{

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	public List<Factura> getAllFacturas() {
		
		return (List<Factura>) facturaRepository.findAll();
	}
	
	@Override
	public Factura getOne(Integer id) {
		
		Optional<Factura> optional = facturaRepository.findById(id);		
		
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public Factura create(Factura factura) {
	
		return facturaRepository.save(factura);
	}

	@Override
	public void delete(Integer id) {
		
		 facturaRepository.deleteById(id);
	}


}
