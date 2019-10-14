package com.spring.primerspringboot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;	
 private String nombre;
 private String ciudad;
 
 // constructor para getter y setters:
 public Clientes() {};
 
 // constructor con campos:
public Clientes(Integer id, String nombre, String ciudad) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.ciudad = ciudad;
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
 
 
}
