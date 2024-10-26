package com.edu.unlam.personajes;

import java.util.*;

import com.edu.unlam.hechizos.Hechizo;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected int puntosDeVida;
	protected boolean tieneVarita = true;
	List<Hechizo> hechizos;
	
	public Personaje(String nombre, int nivelDeMagia, int puntosDeVida, List<Hechizo> hechizos) {
		this.nombre = nombre;
		this.nivelDeMagia = nivelDeMagia;
		this.puntosDeVida = puntosDeVida;
		this.hechizos = hechizos;
	}

	public int getPuntosDeVida() {
		return puntosDeVida;
	}

	public int getNivelDeMagia() {
		return nivelDeMagia;
	}

	public void disminuirPuntosDeVida(int puntosDeVida) {
		this.puntosDeVida -= puntosDeVida;
	}
	
	
}
