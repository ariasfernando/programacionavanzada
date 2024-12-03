package com.example.api_rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.api_rest.entities.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
