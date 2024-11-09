package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class AvadaKedavra extends Maldicion{
	
	//@Override
	public void ejecutar(Personaje objetivo) {
    	int vidaObjetivo = objetivo.getPuntosDeVida();
		objetivo.disminuirPuntosDeVida(vidaObjetivo);
	    System.out.println(objetivo.getNombre() + " ha sido eliminado.");
	        
	    
	}
	
}
