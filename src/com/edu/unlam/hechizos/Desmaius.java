package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Desmaius extends Ofensivo {
	public void ejecutar(Personaje objetivo) {
		objetivo.aturdir();
		System.out.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " ha sido aturdido.");
	}
}
