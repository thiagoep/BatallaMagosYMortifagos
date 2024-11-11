package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Reverse extends Protector {
	public void ejecutar(Personaje objetivo) {
		objetivo.aumentarPuntosDeVida(objetivo.getVidaMaxima());
		System.out.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " ha curado sus heridas.");
	}
}
