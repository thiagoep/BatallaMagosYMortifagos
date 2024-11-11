package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Crucio extends Maldicion {
	public void ejecutar(Personaje objetivo) {
		int vidaObjetivo = objetivo.getPuntosDeVida();
		objetivo.disminuirPuntosDeVida(vidaObjetivo / 2 + 1); // boca
		System.out.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " ha perdido mucha vida.");
	}

}
