package com.edu.unlam.pociones;

import com.edu.unlam.personajes.Personaje;

public class Amortentia implements Pocion {

	@Override
	public void usar(Personaje personaje) {
		personaje.activarEscudo();
		System.out.println(personaje.getNombre()
				+ " tomo la pocion Amortentia, ¡la proxima vez que reciba un ataque su oponente fallara!");
	}

}
