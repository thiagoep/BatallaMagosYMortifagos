package com.edu.unlam.hechizos;


import com.edu.unlam.personajes.Personaje;

public class Confringo extends Ofensivo {

	//@Override
	public void ejecutar(Personaje objetivo) {
		int vidaObjetivo = objetivo.getPuntosDeVida();
		objetivo.disminuirPuntosDeVida(vidaObjetivo-1);
		System.out.println("¡Confringo!");
		System.out.println(objetivo.getNombre() + " ha quedado a uno de vida.");
	}

	
}
