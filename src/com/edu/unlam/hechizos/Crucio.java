package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Crucio extends Maldicion{

	//@Override
	public void ejecutar(Personaje objetivo) {
		int vidaObjetivo = objetivo.getPuntosDeVida();
		objetivo.disminuirPuntosDeVida(vidaObjetivo/2 + 1);
		System.out.println("¡Crucio!");
		System.out.println(objetivo.getNombre() + " ha perdido mucha vida.");
	}


}

