package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Confringo extends Ofensivo {
	public void ejecutar(Personaje objetivo) {
		int vidaObjetivo = objetivo.getPuntosDeVida();
		if (vidaObjetivo == 1) {
			objetivo.disminuirPuntosDeVida(vidaObjetivo);
			System.out.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " ha sido brutalmente atacado.");
		} else {
			objetivo.disminuirPuntosDeVida(vidaObjetivo - 1);
			System.out.println(
					"¡" + this.getNombre() + "! " + objetivo.getNombre() + " ha quedado al borde de la muerte.");
		}
	}
}
