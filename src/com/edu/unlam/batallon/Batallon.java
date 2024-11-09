package com.edu.unlam.batallon;

import java.util.*;

import com.edu.unlam.hechizos.Hechizo;
import com.edu.unlam.personajes.Personaje;

public class Batallon {
	private List<Personaje> personajes;
	private Map<Personaje, Set<Hechizo>> hechizosLanzadosPorRonda;
	
	public Batallon() {
		personajes = new ArrayList<Personaje>();
		hechizosLanzadosPorRonda = new HashMap<>();
	}
	
	public void agregarPersonaje(Personaje personaje) {
		this.personajes.add(personaje);
		registrarHechizos(personaje);
	}
	
	public void registrarHechizos(Personaje personaje) {
		if(personaje == null)
			throw new RuntimeException("Personaje invalido");
		
		if(hechizosLanzadosPorRonda.containsKey(personaje)) {
			Set<Hechizo> hechizos = hechizosLanzadosPorRonda.get(personaje);
			
			hechizosLanzadosPorRonda.put(personaje,hechizos);
		}else {
			Set<Hechizo> hechizos = new HashSet<Hechizo>(personaje.getHechizosLanzados());
			hechizosLanzadosPorRonda.put(personaje,hechizos);
		}
	}

	
	public void eliminarPersonaje(Personaje personaje) {
		this.personajes.remove(personaje);
	}
	
	public boolean tienePersonajesSaludables() {
		/*
		for (Personaje personaje : personajes) {
			if(personaje.getPuntosDeVida() > 0) {
				return true;
			}
		}*/
		
		return personajes.isEmpty();

	}
}
