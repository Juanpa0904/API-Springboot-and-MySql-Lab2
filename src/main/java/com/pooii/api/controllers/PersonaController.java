package com.pooii.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pooii.api.entities.Persona;
import com.pooii.api.service.PersonaService;

@RestController
@RequestMapping(path = "api/v1/personas")
public class PersonaController {

	@Autowired 
	private PersonaService personaService;
	
	//METODO GET TODAS LAS PERSONAS
	@GetMapping
	public List<Persona> getAll(){
		return personaService.getPersonas();
	}
	
	//METODO GET PERSONA POR ID
	@GetMapping("/id/{id}")
	public Optional<Persona> getBId(@PathVariable("id") Long id){
		return personaService.getPersona(id);
	}
	
	//METODO GET PERSONA POR NOMBRE
	@GetMapping("/nombre/{PNombre}")
	public List<Persona> getByNombre(@PathVariable("PNombre")String PNombre){
		return personaService.getNom(PNombre);
	}
	
	//METODO GET PERSONA POR EDAD
	@GetMapping("/edad/{Edad}")
	public List<Persona> getByEdad(@PathVariable("Edad")int Edad){
		return personaService.getEdad(Edad);
	}
	
	//METODO PUT
	@PutMapping
	public Persona update(@RequestBody @Validated Persona persona){
		personaService.saveOrUpdate(persona);
		return persona;
	}
	
	//METODO POST
	@PostMapping
	public Persona save(@RequestBody Persona persona){
		personaService.saveOrUpdate(persona);
		return persona;
	}
	
	//METODO DELETE
	@DeleteMapping("/id/{id}")
	public void saveUpdate(@PathVariable("id") Long id){
		personaService.delete(id);
	}
	
	
	
}
