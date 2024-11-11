package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class AvadaKedavra extends Maldicion{
	public void ejecutar(Personaje objetivo) {
    	int vidaObjetivo = objetivo.getPuntosDeVida();
		objetivo.disminuirPuntosDeVida(vidaObjetivo);
		System.out.println("¡" + this.getNombre() +"! " + objetivo.getNombre() + " ha sido brutalmente atacado.");
	}
}
