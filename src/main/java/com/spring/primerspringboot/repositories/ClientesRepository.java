package com.spring.primerspringboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.primerspringboot.models.Cliente;
@Repository
public interface ClientesRepository extends CrudRepository<Cliente, Integer> {
	//Si quiero querys que no son las básicas las crearía aquí así:
	
	// @Query(value = "SELECT ")
		//public List<Persona> miConsultaCustom();


}
