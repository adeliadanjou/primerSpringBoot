package com.spring.primerspringboot.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	

	// CascadeType.PERSIST ---> solo cuando guarde en base de datos,hace cascada y guarda tambien las facturas pertinentes.
	// CascadeType.ALL ---> en todos los casos (delete,create, update..)
	// .MERGE --> en update solo

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	// Esto de abajo para que no se muestren las facturas cuando haga query de cliente (para quitar loop infinito)
	
 	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Factura> facturas;
	
	@OneToOne()
	@JoinColumn(name="dni_id")
	private Dni dni;
	
	// ANTES DE GUARDAR, VE A TABLA FACTURAS Y GUARDA ESTE CLIENTE:
//	@PrePersist
//	public void persistFactura() {
//		facturas.forEach(factura -> factura.setCliente(this));
//	}

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
