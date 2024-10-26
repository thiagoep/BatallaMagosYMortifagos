package com.edu.unlam.personajes.mortifagos;

import java.util.List;

import com.edu.unlam.hechizos.Hechizo;
import com.edu.unlam.personajes.Personaje;

public abstract class Mortifago extends Personaje {
	protected static int contador = 1;

	public Mortifago(String nombre, int nivelDeMagia, int puntosDeVida, List<Hechizo> hechizos) {
		super(nombre, nivelDeMagia, puntosDeVida, hechizos);
		contador++;
	}

	public static int getContador() {
		return contador;
	}
}
