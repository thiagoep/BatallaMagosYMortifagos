package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class FulminisLacertae extends Ofensivo {
	public void ejecutar(Personaje objetivo) {
		objetivo.disminuirPuntosDeVida(60);
		System.out.println("¡" + this.getNombre() + "! " + objetivo.getNombre() + " ha recibido mucho daño.");
	}
}
