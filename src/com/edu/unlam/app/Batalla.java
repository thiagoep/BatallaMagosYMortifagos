package com.edu.unlam.app;

import com.edu.unlam.batallon.Batallon;
import com.edu.unlam.creacion.PersonajeFactory;
import com.edu.unlam.music.MP3Player;

public class Batalla {
	public static void simularBatalla(int cantidadMagos, int cantidadMortifagos) {
		if ((cantidadMagos + cantidadMortifagos) > 5000)
			throw new IllegalArgumentException("No se pueden crear tantos personajes");

		System.out.println("Esta por presenciar algo iconico, agarrese!");
		try {
			MP3Player.play("src/com/edu/unlam/music/cancionDeApertura.mp3"); // Comenta la linea si np queres escuchar
																				// mas la musica
		} catch (Exception e) {
		}
		System.out.println("\n----------------------------\n");

		Batallon batallonMagos = new Batallon("Los Magos");
		Batallon batallonMortifagos = new Batallon("Los Mortifagos");

		System.out.println("¡El batallon " + batallonMagos.getNombreBatallon()
				+ " está buscando nuevos aliados para la lucha contra las fuerzas oscuras!\n");
		for (int i = 0; i < cantidadMagos; i++) {
			batallonMagos.agregarPersonaje(PersonajeFactory.crearMago());
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		System.out.println("\n----------------------------\n");
		System.out.println("¡El batallon " + batallonMagos.getNombreBatallon()
				+ " reclutan seguidores para expandir la oscuridad y derrotar a los magos!\n");
		for (int i = 0; i < cantidadMortifagos; i++) {
			batallonMortifagos.agregarPersonaje(PersonajeFactory.crearMortifago());
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		System.out.println("\n----------------------------");
		System.out.println("\nLos magos han percibido que los mortifagos se acercan... ¡Empieza la batalla!");

		while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {

			if (batallonMagos.tienePersonajesSaludables()) {
				System.out
						.println("\nEl batallon " + batallonMagos.getNombreBatallon() + " realizara un movimiento...");
				batallonMagos.atacar(batallonMortifagos);
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

			if (batallonMortifagos.tienePersonajesSaludables()) {
				System.out.println(
						"\nEl batallon " + batallonMortifagos.getNombreBatallon() + " realizara un movimiento...");
				batallonMortifagos.atacar(batallonMagos);
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		System.out.println("\n----------------------------\n");
		if (batallonMagos.tienePersonajesSaludables()) {
			System.out.println("¡El batallon " + batallonMagos.getNombreBatallon() + " ha ganado la batalla!");
		} else {
			System.out.println("¡El batallon " + batallonMortifagos.getNombreBatallon() + " ha ganado la batalla!");
		}
	}
}