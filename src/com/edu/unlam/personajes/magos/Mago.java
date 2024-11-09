package com.edu.unlam.personajes.magos;

import java.util.List;

import com.edu.unlam.hechizos.Hechizo;
import com.edu.unlam.hechizos.Protector;
import com.edu.unlam.personajes.Personaje;

public abstract class Mago extends Personaje {
	protected static int contador = 1;
	
	public Mago(String nombre, int nivelDeMagia, int puntosDeVida, List<Hechizo> hechizos) {
		super(nombre, nivelDeMagia, puntosDeVida, hechizos);
		contador++;
	}

	@Override
	public boolean lanzarHechizo(Personaje objetivo) {
		if (!super.lanzarHechizo(objetivo))
			return false;

		if (this.hechizoActual instanceof Protector) {
			this.hechizoActual.ejecutar(this);
		}
		else {
			this.hechizoActual.ejecutar(objetivo);
		}
		return true;
	}

	public static int getContador() {
		return contador;
	}
}
