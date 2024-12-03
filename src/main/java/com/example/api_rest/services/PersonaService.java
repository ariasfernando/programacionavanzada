package com.example.api_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_rest.PersonaDTO;
import com.example.api_rest.PersonaMapper;
import com.example.api_rest.entities.Persona;
import com.example.api_rest.repositories.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	PersonaMapper personaMapper;
	
	public Persona nueva(Persona persona) {
		this.personaRepository.save(persona);
		return persona;
	}
	
	public List<PersonaDTO> getPersonas() {
		List<Persona> pers = (List<Persona>) this.personaRepository.findAll();

		return this.personaMapper.entityToDto(pers);
	}

}
