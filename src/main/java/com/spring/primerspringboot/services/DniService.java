package com.spring.primerspringboot.services;

import java.util.List;
import com.spring.primerspringboot.models.Dni;

public interface DniService {

	// TODOS LOS DNIS:
	public List<Dni> getAllDnis();

	// AÑADIR UN DNI NUEVO:
	public Dni create(Dni dni);

}
