package com.example.api_rest;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public class PersonaDTO {
	
	@NotBlank
	@Length(max = 20, min = 3)
	private String nombre;
	private Long id;
	private DomicilioDTO domicilio;
	
	public DomicilioDTO getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
