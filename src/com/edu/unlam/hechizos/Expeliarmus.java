package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Expeliarmus implements Hechizo{

	@Override
	public void ejecutar(Personaje objetivo) {
		objetivo.desarmar();
		System.out.println("¡Expeliarmus!");
		System.out.println(objetivo.getNombre() + " ha sido desarmado");
	}
}
