package com.edu.unlam.pociones;

import com.edu.unlam.personajes.Personaje;

public class FelixFelicis implements Pocion {

	@Override
	public void usar(Personaje personaje) {
		personaje.recuperarEnergia();
		System.out.println(
				personaje.getNombre() + " tomo la pocion Felix Felicis, ¡la suerte lo favoreció y recargó su energia!");
	}

}
