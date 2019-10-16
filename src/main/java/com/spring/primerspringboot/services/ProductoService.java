package com.spring.primerspringboot.services;

import java.util.List;

import com.spring.primerspringboot.models.Producto;

public interface ProductoService {

	// TODOS LOS CLIENTES:
	public List<Producto> getAllProductos();
	// CLIENTE POR ID:
	public Producto getOne(Integer id);
	// AÑADIR UN CLIENTE NUEVO:
	public Producto create(Producto producto);
	// DELETE CLIENTE:
	public void delete(Integer id);
	// UPDATE CLIENTE:
//	public Cliente update();
}
