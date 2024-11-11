package com.edu.unlam.pociones;

import com.edu.unlam.personajes.Personaje;

public class EsenciaDeMurtlap implements Pocion {

	@Override
	public void usar(Personaje personaje) {
		personaje.aumentarPuntosDeVida(personaje.getVidaMaxima());
		System.out.println(personaje.getNombre() + " tomo la pocion Esencia De Murtlap, ¡se ha curado sus heridas!");
	}
}
