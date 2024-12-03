package com.example.api_rest;

import java.util.ArrayList;
import java.util.List;

import com.example.api_rest.entities.Persona;

public class PersonaMapper {
	
	public Persona dtoToEntity(PersonaDTO dto) {
		Persona p = new Persona();
		p.setId(dto.getId());
		p.setNombre(dto.getNombre());
		return p;
	}
	
	public PersonaDTO entityToDto(Persona p) {
		PersonaDTO dto = new PersonaDTO();
		dto.setId(p.getId());
		dto.setNombre(p.getNombre());
		dto.setDomicilio(null);
		return dto;
	}

	public List<Persona> dtoToEntity(List<PersonaDTO> dto) {
		List<Persona> p = new ArrayList<>();
		for(PersonaDTO d: dto) {
			p.add(this.dtoToEntity(d));
		}
		return p;
	}
	
	public List<PersonaDTO> entityToDto(List<Persona> p) {
		List<PersonaDTO> dto = new ArrayList<>();
		for(Persona d: p) {
			dto.add(this.entityToDto(d));
		}
		return dto;
	}
}
