package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class AvadaKedavra implements Hechizo {
	
	@Override
	public void ejecutar(Personaje objetivo) {
		int vidaObjetivo = objetivo.getPuntosDeVida();
		objetivo.disminuirPuntosDeVida(vidaObjetivo);
		System.out.println("¡Avada Kedavra!");
		System.out.println(objetivo.getNombre() + " ha sido eliminado.");
	}

}
