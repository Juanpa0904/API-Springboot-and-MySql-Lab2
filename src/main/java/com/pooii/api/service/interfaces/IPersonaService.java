package com.pooii.api.service.interfaces;

import java.util.List;
import com.pooii.api.entities.Persona;

public interface IPersonaService {

	//METODOS CRUD
		boolean save(Persona persona);
		
		boolean update(Persona persona);
		
		boolean delete(int id);
		
		List<Persona> getPersonas();
		

		//LISTA DE PERSONA POR ID
		Persona getPersona(int id);
		
		//LISTA DE PERSONA POR PRIMER NOMBRE
		List<Persona> getNom(String pnombre);
		
		//LISTA DE PERSONA POR EDAD
		List<Persona> getEdad(int edad);
}
