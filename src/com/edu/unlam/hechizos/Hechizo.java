package com.edu.unlam.hechizos;

import com.edu.unlam.personajes.Personaje;

public interface Hechizo {

	public void ejecutar(Personaje objetivo);

	public String getNombre();

}
