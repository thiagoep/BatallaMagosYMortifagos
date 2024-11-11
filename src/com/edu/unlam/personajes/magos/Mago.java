package com.edu.unlam.personajes.magos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.edu.unlam.hechizos.Hechizo;
import com.edu.unlam.hechizos.Protector;
import com.edu.unlam.personajes.Personaje;
import com.edu.unlam.pociones.*;

public abstract class Mago extends Personaje {

	private List<Pocion> pociones;

	public Mago(String nombre, int nivelDeMagia, int puntosDeVida, List<Hechizo> hechizos) {
		super(nombre, nivelDeMagia, puntosDeVida, hechizos);
		pociones = new ArrayList<>();
	}

	public boolean lanzarHechizo(Personaje objetivo) {

		if (!super.lanzarHechizo(objetivo))
			return false;

		if (this.hechizoActual instanceof Protector) {
			this.hechizoActual.ejecutar(this);
		} else {
			this.hechizoActual.ejecutar(objetivo);
		}
		return true;
	}

	private void usarPocion(Pocion pocion) {
		if (!pociones.contains(pocion))
			throw new NoSuchElementException("Error: La poción no está en tu inventario.");
		pocion.usar(this);
		pociones.remove(pocion);
	}

	public void activarHabilidadEspecial() {
		boolean exito = false;
		System.out.println(nombre + " esta intentando crear pociones.");
		if ((int) (Math.random() * 2) == 0) {
			pociones.add(new Amortentia());
			System.out.println(nombre + " creo la pocion Amortentia, ¡si la usa enamorara a su proximo atacante!");
			exito = true;
		}

		if ((int) (Math.random() * 2) == 0) {
			pociones.add(new EsenciaDeMurtlap());
			System.out.println(nombre + " creo la pocion Esencia De Murtlap, ¡si la usa se curaran sus heridas!");
			exito = true;
		}

		if ((int) (Math.random() * 2) == 0) {
			pociones.add(new FelixFelicis());
			System.out.println(nombre + " creo la pocion Felix Felicis, ¡si la usa obtendra suerte!");
			exito = true;
		}

		if (!exito)
			System.out.println(nombre + " ha fracasado creando pociones.");

	}

	public boolean tieneHabilidadesEspeciales() {
		return !pociones.isEmpty();
	}

	public void usarHabilidadEspecial() {

		for (Pocion pocion : pociones) {
			if (puntosDeVida < 30 && pocion instanceof EsenciaDeMurtlap) {
				usarPocion(pocion);
				return;
			} else if (nivelDeEnergia < 30 && pocion instanceof FelixFelicis) {
				usarPocion(pocion);
				return;
			} else if (!tieneEscudo() && pocion instanceof Amortentia) {
				usarPocion(pocion);
				return;
			}
		}

		usarPocion(pociones.getFirst());
	}
}
