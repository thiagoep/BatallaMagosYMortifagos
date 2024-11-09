package com.edu.unlam.personajes;

import java.util.*;

import com.edu.unlam.hechizos.Hechizo;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected int puntosDeVida;
	
	protected boolean tieneVarita = true;
	protected boolean escudo = false;
	protected boolean aturdido = false;
	
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

	
	public void setHechizoActual(Hechizo hechizo) {
		if(hechizo == null)
			throw new RuntimeException("Hechizo invalido");
		this.hechizoActual = hechizo;

	}
	
	public boolean lanzarHechizo(Personaje objetivo) {
		
		if(this.estaAturdido()) {
        	System.out.println("¡" + this.getNombre() + " no ha podido atacar porque esta aturdido!");
        	this.despertar();
        	System.out.println("¡" + this.getNombre() + " se ha despertado!");
        	return false;
	    }
	    
		if(!this.estaArmado()) {
        	System.out.println("¡" + this.getNombre() + " no ha podido atacar porque no tiene varita!");
        	this.armar();
        	System.out.println("¡" + this.getNombre() + " ha agarrado su varita!");
        	return false;
	    }
		
		if(objetivo.tieneEscudo()) {
        	System.out.println("¡" + objetivo.getNombre() + " tenia escudo! El hechizo no surtió efecto.");
        	objetivo.desactivarEscudo();
        	return false;
		}
	    
	    if(objetivo.getPuntosDeVida() <= 0) {
	    	// hacer algo si se queda sin vida
	    	// si eliminamos, al final no podemos usar tienePersonajesSaludables()
	    }
	    
	    System.out.println("*" + this.getNombre() + " ha lanzado " + this.hechizoActual.getNombre() + "*");
	    
	    return true;
	}
	
	public boolean estaArmado() {
		return this.tieneVarita;
	}
	
	public boolean estaAturdido() {
		return this.aturdido;
	}
	
	public boolean tieneEscudo() {
		return this.escudo;
	}
	
	public void armar() {
		this.tieneVarita = true;
	}
	
	public void desarmar() {
		this.tieneVarita = false;
	}
	
	public void despertar() {
		this.aturdido = false;
	}
	
	public void aturdir() {
		this.aturdido = true;
	}
	
	public void activarEscudo() {
		this.escudo = false;
	}
	
	public void desactivarEscudo() {
		this.escudo = false;
	}
	
}
