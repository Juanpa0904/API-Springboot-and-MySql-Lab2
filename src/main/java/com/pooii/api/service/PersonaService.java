package com.pooii.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pooii.api.entities.Persona;
import com.pooii.api.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	
	// búsqueda de todas las personas
	public List<Persona> getPersonas(){
		return personaRepository.findAll();
	}
	
	// búsqueda de una persona por id
	public Optional<Persona> getPersona(Long id){
		return personaRepository.findById(id);
	}
		
	// búsqueda de una persona por nombre
	public List<Persona> getNom(String pnombre){
		return personaRepository.findByPNombre(pnombre);
	}
	
	// búsqueda de una persona por edad
		public List<Persona> getEdad(int Edad){
			return personaRepository.findByEdad(Edad);
		}
		
	public void  saveOrUpdate(Persona persona) {
		personaRepository.save(persona);
	}
	
	
	//Eliminar persona
	public void  delete(Long id) {
		personaRepository.deleteById(id);
	}
		
}
