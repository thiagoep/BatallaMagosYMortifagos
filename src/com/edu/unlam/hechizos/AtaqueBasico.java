package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class AtaqueBasico extends Ofensivo {
	public void ejecutar(Personaje objetivo) {
		objetivo.disminuirPuntosDeVida(10);
		System.out.println(objetivo.getNombre() + " ha recibido un leve ataque.");
	}
}
