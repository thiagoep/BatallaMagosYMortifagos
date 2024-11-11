package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Incendio extends Ofensivo{

	@Override
	public void ejecutar(Personaje objetivo) {
		objetivo.disminuirPuntosDeVida(50);
		System.out.println("¡"+ this.getNombre() +"! "+objetivo.getNombre() + " ha sido prendido fuego");
	}
	
}
