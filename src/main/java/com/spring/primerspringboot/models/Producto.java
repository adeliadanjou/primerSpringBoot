package com.spring.primerspringboot.models;
import javax.persistence.Entity;
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
	private String nombre;
	private String pais;
	
	// establecemos una relacion ManyToMany con la tabla de facturas con el mappedBy ="facturas"
	@ManyToMany(mappedBy = "productos")
	private List<Factura> facturas;
	
	// Constructores + Setters + Getters:
	
	public Producto() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Producto(Integer id, String nombre, String pais, List<Factura> facturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.facturas = facturas;
	}
	
	
	
}