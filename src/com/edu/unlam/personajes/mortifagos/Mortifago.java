package com.edu.unlam.personajes.mortifagos;

import java.util.List;

import com.edu.unlam.hechizos.*;
import com.edu.unlam.personajes.Personaje;

public abstract class Mortifago extends Personaje {
	private boolean marcaTenebrosa = false;

	public Mortifago(String nombre, int nivelDeMagia, int puntosDeVida, List<Hechizo> hechizos) {
		super(nombre, nivelDeMagia, puntosDeVida, hechizos);
	}

	public boolean lanzarHechizo(Personaje objetivo) {
		if (!super.lanzarHechizo(objetivo))
			return false;

		this.hechizoActual.ejecutar(objetivo);

		return true;
	}

	@Override
	public void activarHabilidadEspecial() {
		if (marcaTenebrosa) {
			System.out.println("Intentaron marcarse con la marca tenebrosa, pero fracasaron.");
			return;
		}

		System.out.println(nombre + " se ha marcado con la marca tenebrosa, "
				+ "¡tiene tanto poder que podria derrotar a un enemigo de un solo ataque!");
		marcaTenebrosa = true;
	}

	@Override
	public boolean tieneHabilidadesEspeciales() {
		return marcaTenebrosa;
	}

	@Override
	public void usarHabilidadEspecial() {
		hechizoActual = new AvadaKedavra();
		marcaTenebrosa = false;
		nivelDeEnergia = 100;
		System.out.println(nombre + " va a usar su marca tenebrosa.");
	}

}
