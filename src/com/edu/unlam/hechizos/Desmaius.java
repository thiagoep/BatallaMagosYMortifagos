package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Desmaius extends Ofensivo {

	//@Override
	public void ejecutar(Personaje objetivo) {
		System.out.println("¡Desmaius!");
	    objetivo.aturdir();
	    System.out.println(objetivo.getNombre() + " ha sido aturdido");
    }

}
