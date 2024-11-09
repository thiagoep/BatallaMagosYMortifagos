package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Expelliarmus extends Ofensivo{

	//@Override
	public void ejecutar(Personaje objetivo) {
		System.out.println("¡" + this.getNombre() +"! ");	    
	    objetivo.desarmar();
	    System.out.println("*" + objetivo.getNombre() + " ha sido desarmado*");
	}

	
}
