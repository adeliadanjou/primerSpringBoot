package com.spring.primerspringboot.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.omg.CORBA.PRIVATE_MEMBER;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// Con anotaciones persistence no hace falta poner en controller @Valid
	@javax.persistence.Column(unique = true)
	// Con anotaciones de spring hay que poner en controller @Valid (al lado de
	// @requestBody
	@NotNull
	private String nombre;
	private String ciudad;
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;
	
	@OneToOne()
	@JoinColumn(name="dni_id", nullable = false)
	private Dni dni;
	

	// constructor para getter y setters:
	public Cliente() {
	};

	// constructor con campos:
	public Cliente(Integer id, @NotNull String nombre, String ciudad, List<Factura> facturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.facturas = facturas;
	}
	
	// a partir de aquí getters y setters...
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}


	

}
