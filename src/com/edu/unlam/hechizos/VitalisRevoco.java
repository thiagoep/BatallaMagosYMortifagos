package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class VitalisRevoco extends Protector {
	public void ejecutar(Personaje objetivo) {
		objetivo.aumentarPuntosDeVida(30);
		System.out.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " se ha curado algunas heridas.");
	}
}
