package com.pooii.api.entities;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "pnombre")
	private String PNombre;
	
	@Column(name = "edad")
	private int edad; 
	
	public Persona() {
		
	}

	public Persona(int id, String pNombre, int edadd) {
		super();
		this.id = id;
		PNombre = pNombre;
		edad = edadd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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