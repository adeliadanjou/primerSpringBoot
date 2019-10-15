package com.spring.primerspringboot.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date;

	// Aquí almacenamos el id del cliente (clave ajena)
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;// <---- este cliente es el mismo nombre de mappedBy

	
	// Aquí establecemos con manyToMany una relacion con la tabla producto de n/n
	// @JoinTable es para crear una nueva tabla con los ids de facturas relacionados con productos
	@ManyToMany
	@JoinTable(
			name = "PRODUCTOS-FACTURAS",
			joinColumns = @JoinColumn(name = "factura_id"),
			inverseJoinColumns = @JoinColumn(name = "producto_id")
			)
	private List<Producto> productos;

	// PrePersist se usa para que el metodo que tiene abajo se use justo antes de
	// guardar en base de datos(persistir)
	@PrePersist
	public void setFecha() {
		date = new Date();
	}

	public Factura(Integer id, Date date, Cliente cliente, List<Producto> productos) {
		super();
		this.id = id;
		this.date = date;
		this.cliente = cliente;
//		this.productos = productos;
	}

	public Factura() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
//
//	public List<Producto> getProductos() {
//		return productos;
//	}
//
//	public void setProductos(List<Producto> productos) {
//		this.productos = productos;
//	}

}
