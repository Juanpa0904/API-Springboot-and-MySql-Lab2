package com.pooii.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping(path = "api/v1")
public class PersonaController {

	@Autowired
	@Qualifier("personaService")
	private PersonaService personaService;

	// METODO POST
	@PostMapping("/persona")
	public boolean save(@RequestBody Persona persona) {
		return personaService.save(persona);
	}

	// METODO PUT
	@PutMapping("/persona")
	public boolean update(@RequestBody @Validated Persona persona) {
		return personaService.update(persona);
	}

	// METODO DELETE
	@DeleteMapping("/persona/{id}")
	public boolean saveUpdate(@PathVariable("id") int id) {
		return personaService.delete(id);
	}

	// METODO GET TODAS LAS PERSONAS
	@GetMapping("/personas")
	public List<Persona> getAll() {
		return personaService.getPersonas();
	}

	// METODO GET PERSONA POR ID
	@GetMapping("/persona/id/{id}")
	public Persona getBId(@PathVariable("id") int id) {
		return personaService.getPersona(id);
	}

	// METODO GET PERSONA POR NOMBRE
	@GetMapping("/persona/nombre/{PNombre}")
	public List<Persona> getByNombre(@PathVariable("PNombre") String PNombre) {
		return personaService.getNom(PNombre);
	}

	@GetMapping("/persona/edad/{Edad}")
	// METODO GET PERSONA POR EDAD
	public List<Persona> getByEdad(@PathVariable("Edad") int Edad) {
		return personaService.getEdad(Edad);
	}

}
