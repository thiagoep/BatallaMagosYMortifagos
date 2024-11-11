package com.edu.unlam.batallon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import java.util.Collections;

import com.edu.unlam.hechizos.Hechizo;
import com.edu.unlam.personajes.Personaje;
import com.edu.unlam.personajes.magos.Mago;
import com.edu.unlam.personajes.mortifagos.Mortifago;

public class Batallon {
	private Personaje personajeActual;
	private List<Personaje> personajes;
	private Set<Hechizo> hechizosLanzadosPorRonda;
	private String nombreBatallon;
	private int pos;

	public Batallon(String nombreBatallon) {
		if (nombreBatallon == null) {
			throw new IllegalArgumentException("El nombre no puede ser nulo.");
		}

		personajes = new ArrayList<Personaje>();
		hechizosLanzadosPorRonda = new HashSet<>();
		this.nombreBatallon = nombreBatallon;
		pos = 0;
	}

	public void agregarPersonaje(Personaje personaje) {
		if (personaje == null)
			throw new IllegalArgumentException("Personaje invalido");

		if (personajes.isEmpty())
			personajeActual = personaje;
		else if (personajeActual instanceof Mago && !(personaje instanceof Mago)) {
			throw new IllegalArgumentException("Un Mortifago no puede unirse al equipo de Magos");
		} else if (personajeActual instanceof Mortifago && !(personaje instanceof Mortifago)) {
			throw new IllegalArgumentException("Un Mago no puede unirse al equipo de Mortifagos");
		}

		this.personajes.add(personaje);
		System.out.println(personaje.getNombre() + " se ha unido al batallon " + nombreBatallon + ".");
	}

	private void eliminarPersonaje(Personaje personaje) {
		if (personaje == null) {
			throw new IllegalArgumentException("No se puede eliminar un personaje nulo.");
		}

		if (!personajes.contains(personaje)) {
			throw new NoSuchElementException("El personaje no se encuentra en el batallón.");
		}

		personajes.remove(personaje);
	}

	public Personaje getPersonajeAleatorio() {
		if (personajes.isEmpty()) {
			throw new NoSuchElementException("No hay personajes en el batallón.");
		}

		return personajes.get((int) Math.random() * personajes.size());
	}

	public String getNombreBatallon() {
		return nombreBatallon;
	}

	private void nuevaRonda() {
		pos = 0;
		Collections.shuffle(personajes);
		personajeActual = personajes.getFirst();
		hechizosLanzadosPorRonda.clear();
	}

	public void atacar(Batallon batallon) {
		if(batallon==this)
			throw new RuntimeException("No se puede atacar al mismo batallon.");
		
		Personaje objetivo;
		int habilidad = 0;

		if (pos >= personajes.size()) {
			System.out.println("El batallon " + nombreBatallon + " ha dejado de realizar ataques.\n");
			batallon.activarHabilidadEspecial();
			this.nuevaRonda();
			batallon.nuevaRonda();
			System.out.println("¡Se han reagrupado los batallones y la pelea continua!");
			return;
		}

		if (personajeActual.tieneHabilidadesEspeciales()) {
			if (personajeActual instanceof Mago) {
				personajeActual.usarHabilidadEspecial();
				return;
			}
			habilidad = (int) (Math.random() * 2);
			if (habilidad == 1) {
				personajeActual.usarHabilidadEspecial();
			}
		}

		if (habilidad != 1 && !personajeActual.setHechizoActualSet(hechizosLanzadosPorRonda)) {
			System.out.println("El batallon " + nombreBatallon + " ha dejado de realizar ataques.\n");
			batallon.activarHabilidadEspecial();
			this.nuevaRonda();
			batallon.nuevaRonda();
			System.out.println("¡Se han reagrupado los batallones y la pelea continua!");
			return;
		}

		objetivo = batallon.getPersonajeAleatorio();

		if (personajeActual.lanzarHechizo(objetivo)) {
			hechizosLanzadosPorRonda.add(objetivo.getHechizoActual());

			if (objetivo.getPuntosDeVida() <= 0) {
				batallon.eliminarPersonaje(objetivo);				
				System.out.println(objetivo.getNombre() + " ha sido derrotado.");
				if (objetivo.getNombre().equalsIgnoreCase("Lord Voldemort")) {
					System.out.println("\n----------------------------\n");
					System.out.println("¡Lord Voldemort fue derrotado y el batallon " + nombreBatallon
							+ " logró combatir a la oscuridad!");
					System.exit(1);
				}
			}
		}

		pos++;
		if (pos < personajes.size())
			personajeActual = personajes.get(pos);

	}

	private void activarHabilidadEspecial() {

		Personaje personaje = this.getPersonajeAleatorio();

		System.out.println("El batallon " + nombreBatallon
				+ " aprovecha la tranquilidad para realizar una acción estratégica en la batalla.");
		personaje.activarHabilidadEspecial();
	}

	public boolean tienePersonajesSaludables() {
		return !personajes.isEmpty();
	}
}
