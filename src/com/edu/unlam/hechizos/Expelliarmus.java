package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Expelliarmus extends Ofensivo {
	public void ejecutar(Personaje objetivo) {
		objetivo.desarmar();
		System.out.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " ha sido desarmado.");
	}
}
