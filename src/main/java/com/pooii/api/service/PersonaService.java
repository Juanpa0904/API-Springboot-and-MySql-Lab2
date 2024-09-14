package com.pooii.api.service;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pooii.api.entities.Persona;
import com.pooii.api.repository.PersonaRepository;
import com.pooii.api.service.interfaces.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService {

	@Autowired
	@Qualifier("personaRepository")
	private PersonaRepository personaRepository;

	// ==================== LOGS ============================

	// LOGS DE ERROR

	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(PersonaService.class);

	// INSERT
	@Override
	public boolean save(Persona persona) {
		try {
			if (persona == null) {
				logger.error("ERROR AGREGAR_PERSONA: LA PERSONA ES NULO!");
				return false;
			} else {
				personaRepository.save(persona);
				return true;
			}
		} catch (Exception e) {
			logger.error("ERROR AGREGAR_PERSONA: LA PERSONA NO SE HA GUARDADO!");
			return false;
		}
	}

	// UPDATE
	@Override
	public boolean update(Persona persona) {
		try {
			if ((persona == null) || (persona.getId() == 0)) {
				logger.error("ERROR_EDITAR_PERSONA:  LA PERSONA ES NULO O EL ID ES 0!");
				return false;
			} else {
				personaRepository.save(persona);
				return true;
			}
		} catch (Exception e) {
			logger.error("ERROR EDITAR_PERSONA: LA PERSONA NO SE HA EDITADO!");
			return false;
		}
	}
	
	//DELETE
		@Override
		public boolean delete(int id) {
			try {
				if ((id == 0)) {
					logger.error("ERROR ELIMINAR_PERSONA: EL ID DEL PERSONA ES 0!");
					return false;
				}
				else {
					Persona persona = personaRepository.findById(id);
					personaRepository.delete(persona);
					return true;
				}
			}catch(Exception e) {
				logger.error("ERROR ELIMINAR_PERSONA: LA PERSONA NO SE HA ELIMINADO!");
				return false;
			} 
		}
	
	

	// READ
	@Override
	public List<Persona> getPersonas() {
		return personaRepository.findAll();
	}

	//================ METODOS DE BUSQUEDA =============================

	// búsqueda de una persona por id
	public Persona getPersona(int id) {
		return personaRepository.findById(id);
	}

	// búsqueda de una persona por nombre
	public List<Persona> getNom(String pnombre) {
		return personaRepository.findByPNombre(pnombre);
	}

	// búsqueda de una persona por edad
	public List<Persona> getEdad(int Edad) {
		return personaRepository.findByEdad(Edad);
	}

}
