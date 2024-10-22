package com.edu.unlam.personajes;

import java.util.*;

import com.edu.unlam.hechizos.Hechizo;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected int puntosDeVida;
	List<Hechizo> hechizos;
	
	public Personaje() {
		this.hechizos = new ArrayList<Hechizo>();
	}
	
	public int getPuntosDeVida() {
		return puntosDeVida;
	}
}
