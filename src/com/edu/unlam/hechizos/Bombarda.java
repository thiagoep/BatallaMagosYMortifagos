package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Bombarda extends Ofensivo {
	public void ejecutar(Personaje objetivo) {
		objetivo.disminuirPuntosDeVida(50);
		System.out.println("¡" + this.getNombre() +"! "+objetivo.getNombre() + " ha perdido algo de vida.");
	}
}