package com.pooii.api.repository;

import com.pooii.api.entities.Persona;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	 
	public abstract Persona findById(int id);
	public abstract List<Persona> findByPNombre(String pnombre);
	public abstract List<Persona> findByEdad(int Edad);
	
}

