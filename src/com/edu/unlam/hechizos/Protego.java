package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public class Protego extends Protector {

	@Override
    public void ejecutar(Personaje objetivo) {
        objetivo.activarEscudo();
        System.out.println("¡" + this.getNombre() +"! " + objetivo.getNombre() + " está protegido.");
    }
	

}
