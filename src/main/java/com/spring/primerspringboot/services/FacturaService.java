package com.spring.primerspringboot.services;

import java.util.List;

import com.spring.primerspringboot.models.Factura;

public interface FacturaService {

	// TODAS LAS FACTURAS:
	public List<Factura> getAllFacturas();

	// FACTURA POR ID:
	public Factura getOne(Integer id);

	// AÑADIR UNA FACTURA NUEVA O MODIFICAR SI PASO ID en body:
	public Factura create(Factura factura);

	// DELETE FACTURA:
	public void delete(Integer id);


}
