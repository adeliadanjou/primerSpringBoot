package com.spring.primerspringboot.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

public class Dni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Min(value = 9)
	private String numeroDni;
	
	@OneToOne(mappedBy = "dni")
	private Cliente cliente;
	

}
