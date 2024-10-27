package com.edu.unlam.personajes;

import java.util.*;

import com.edu.unlam.hechizos.Hechizo;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected int puntosDeVida;
	protected boolean tieneVarita = true;
	List<Hechizo> hechizos;
	protected Hechizo hechizoActual;
	
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
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void desarmar() {
		this.tieneVarita = false;
	}
	
	public void setHechizoActual(Hechizo hechizo) {
		this.hechizoActual = hechizo;
	}
	
	public void lanzarHechizo(Personaje objetivo){
		this.hechizoActual.ejecutar(objetivo);
	}
	
}
