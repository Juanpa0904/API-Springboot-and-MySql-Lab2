package com.pooii.api.repository;

import com.pooii.api.entities.Persona;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	 
	
	public abstract List<Persona> findByPNombre(String pnombre);
	public abstract List<Persona> findByEdad(int Edad);
	
}

