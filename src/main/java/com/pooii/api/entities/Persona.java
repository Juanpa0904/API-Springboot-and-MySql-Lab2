package com.pooii.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String PNombre;
	private int edad; 
	
	public Persona() {
		
	}

	public Persona(Long id, String pNombre, int edadd) {
		super();
		this.id = id;
		PNombre = pNombre;
		edad = edadd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPNombre() {
		return PNombre;
	}

	public void setPNombre(String pNombre) {
		PNombre = pNombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edadd) {
		edad = edadd;
	}
	
	
	
}