package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Bombarda extends Ofensivo {
	
	//@Override
	public void ejecutar(Personaje objetivo) {
		objetivo.disminuirPuntosDeVida(50);
		System.out.println("¡Bombarda!");
		System.out.println(objetivo.getNombre() + " ha perdido algo de vida.");
	}

}