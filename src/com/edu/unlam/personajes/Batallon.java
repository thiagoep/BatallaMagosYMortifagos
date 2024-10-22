package com.edu.unlam.personajes;

import java.util.*;

public class Batallon {
	private List<Personaje> personajes;
	
	public Batallon() {
		personajes = new ArrayList<Personaje>();
	}
	
	public void agregarPersonaje(Personaje personaje) {
		this.personajes.add(personaje);
	}
	
	public boolean tienePersonajesSaludables() {
		for (Personaje personaje : personajes) {
			if(personaje.getPuntosDeVida() > 0) {
				return true;
			}
		}
		return false;
	}
}
