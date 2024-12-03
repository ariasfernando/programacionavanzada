package com.example.api_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_rest.PersonaDTO;
import com.example.api_rest.entities.Persona;
import com.example.api_rest.services.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	PersonaService personaService;
	
	@GetMapping({"saludo/{name}", "/saludo"})
	public String getMensaje(@PathVariable(required = false) String name) {
		if(name == null) {
			return "Hola mundo";
		} else {
			return "Hola " + name;
		}
	}
	
	@GetMapping("/mensaje/{name}")
	public ResponseEntity<String> getMensajes(@PathVariable String name) {
		
		if(name.length() < 3) {
			return new ResponseEntity<String>("El nombre es muy corto", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("Hola " + name, HttpStatus.OK);	
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getPersonas() {
		List <PersonaDTO> pers = this.personaService.getPersonas();
		return new ResponseEntity<List<PersonaDTO>>(pers, HttpStatus.OK);
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevaPersona(@RequestBody Persona p){
		p = personaService.nueva(p);
		return new ResponseEntity<String>("Se creo " + p.toString(), HttpStatus.OK);

	}
	
	
}
