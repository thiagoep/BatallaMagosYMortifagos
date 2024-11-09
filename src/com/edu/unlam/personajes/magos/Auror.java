package com.edu.unlam.personajes.magos;

import java.util.List;

import com.edu.unlam.hechizos.Hechizo;

public class Auror extends Mago {
	private final static int magiaBase = 80;

	public Auror(String nombre, int nivelDeMagia, int puntosDeVida, List<Hechizo> hechizos) {
		super(nombre, nivelDeMagia + magiaBase, puntosDeVida, hechizos);
	}

	@Override
	public void desarmar() {
		// TODO Auto-generated method stub
		this.armar();
	}
	
}
