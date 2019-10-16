package com.spring.primerspringboot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.primerspringboot.models.Dni;

import com.spring.primerspringboot.services.DniServiceImpl;

@RestController
@RequestMapping(path = "/dnis")
public class DniController {

	  @Autowired
	  private DniServiceImpl dniService;
	  
	  // LISTA TODOS LOS DNIS
		@GetMapping()
		public List<Dni> getAll(){
			return dniService.getAllDnis();
		}
		
		// CREA DNIS O LOS MODIFICA SI VIENE CON ID
		@PostMapping("/create")
		public ResponseEntity<Dni> saveDni(@RequestBody @Valid Dni dni){
			
			return new ResponseEntity<Dni>(dniService.create(dni), HttpStatus.OK);
	
		}
		
}
