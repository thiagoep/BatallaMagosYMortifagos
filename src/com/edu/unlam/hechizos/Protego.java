package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Protego extends Protector {
	public void ejecutar(Personaje objetivo) {
		objetivo.activarEscudo();
		System.out.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " se ha protegido");
	}
}
