package com.spring.primerspringboot.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

@Entity
public class Dni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, length = 9 )
	private String numero_dni;
	
	@OneToOne(mappedBy = "dni")
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero_dni() {
		return numero_dni;
	}

	public void setNumero_dni(String numero_dni) {
		this.numero_dni = numero_dni;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Dni() {
	
	}

	public Dni(Integer id, @Min(9) String numero_dni, Cliente cliente) {
		super();
		this.id = id;
		this.numero_dni = numero_dni;
		this.cliente = cliente;
	}
	
	

}
