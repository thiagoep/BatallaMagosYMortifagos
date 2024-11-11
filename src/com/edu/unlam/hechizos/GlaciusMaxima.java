package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class GlaciusMaxima extends Ofensivo {
	public void ejecutar(Personaje objetivo) {
		objetivo.disminuirPuntosDeVida(20);
		objetivo.aturdir();
		System.out
				.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " ha sido atacado y se ha desmayado.");
	}
}
