package com.edu.unlam.hechizos;

public abstract class Ofensivo implements Hechizo {
	public String getNombre() {
		return getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2");
	}
}
