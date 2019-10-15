package com.spring.primerspringboot.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	// establecemos una relacion ManyToMany con la tabla de facturas con el mappedBy ="facturas"
	@ManyToMany(mappedBy = "productos")
	private List<Factura> facturas;
	
	public Producto() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Producto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
