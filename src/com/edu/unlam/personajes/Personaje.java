package com.edu.unlam.personajes;

import java.util.*;

import org.jpl7.Query;
import org.jpl7.Term;

import com.edu.unlam.hechizos.Hechizo;
import com.edu.unlam.implementacionProlog.ImplementacionProlog;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected int puntosDeVida;
	protected final int vidaMaxima;
	protected int nivelDeEnergia;
	protected final int energiaMaxima;

	protected boolean tieneVarita = true;
	protected boolean escudo = false;
	protected boolean aturdido = false;

	protected List<Hechizo> hechizos;
	protected Hechizo hechizoActual;

	public Personaje(String nombre, int nivelDeMagia, int puntosDeVida, List<Hechizo> hechizos) {

		if (nombre == null) {
			throw new IllegalArgumentException("El nombre no puede ser nulo.");
		}
		if (nivelDeMagia < 0) {
			throw new IllegalArgumentException("El nivel de magia no puede ser negativo.");
		}
		if (puntosDeVida <= 0) {
			throw new IllegalArgumentException("Los puntos de vida deben ser mayores que cero.");
		}
		if (hechizos == null) {
			throw new NullPointerException("La lista de hechizos no puede ser nula.");
		}
		if (hechizos.isEmpty()) {
			throw new IllegalArgumentException("La lista de hechizos no puede estar vacia.");
		}

		this.nombre = nombre;
		this.nivelDeMagia = nivelDeMagia;
		this.puntosDeVida = puntosDeVida;
		this.vidaMaxima = puntosDeVida;
		this.hechizos = hechizos;
		this.nivelDeEnergia = 100;
		this.energiaMaxima = 100;
	}

	public int getPuntosDeVida() {
		return puntosDeVida;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public int getNivelDeMagia() {
		return nivelDeMagia;
	}

	public int getNivelDeEnergia() {
		return nivelDeEnergia;
	}

	public void disminuirPuntosDeVida(int puntosDeVida) {
		if (puntosDeVida <= 0) {
			throw new RuntimeException("Los puntos de vida a disminuir no puede ser negativo");
		}

		this.puntosDeVida -= puntosDeVida;
	}

	public void aumentarPuntosDeVida(int puntosDeVida) {
		if (puntosDeVida <= 0) {
			throw new RuntimeException("Los puntos de vida a aumentar no puede ser negativo");
		}

		this.puntosDeVida += puntosDeVida;
		if (this.puntosDeVida > this.vidaMaxima)
			this.puntosDeVida = this.vidaMaxima;
	}

	public void disminuirNivelDeEnergia(int nivelDeEnergia) {
		if (nivelDeEnergia <= 0) {
			throw new RuntimeException("El nivel de energia a disminuir no puede ser negativo");
		}

		this.nivelDeEnergia -= nivelDeEnergia;
	}

	public void recuperarEnergia() {
		this.nivelDeEnergia = energiaMaxima;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Hechizo getHechizoAleatorio() {
		return hechizos.get((int) (Math.random() * hechizos.size()));
	}

	public Hechizo getHechizoActual() {
		return hechizoActual;
	}

	public boolean setHechizoActualSet(Set<Hechizo> hechizosLanzados) {
		for (Hechizo hechizo : this.hechizos) {
			if (!hechizosLanzados.contains(hechizo)) {
				this.setHechizoActual(hechizo);
				return true;
			}
		}
		return false;
	}

	public void setHechizoActual(Hechizo hechizo) {
		if (hechizo == null) {
			throw new IllegalArgumentException("El hechizo no puede ser nulo.");
		}

		hechizoActual = hechizo;
	}

	public boolean lanzarHechizo(Personaje objetivo) {

		if (this.estaAturdido()) {
			System.out.println("¡" + this.getNombre() + " no ha podido atacar porque esta aturdido!");
			this.despertar();
			System.out.println("¡" + this.getNombre() + " se ha despertado!");
			return false;
		}

		if (!this.estaArmado()) {
			System.out.println("¡" + this.getNombre() + " no ha podido atacar porque no tiene varita!");
			this.armar();
			System.out.println("¡" + this.getNombre() + " ha agarrado su varita!");
			return false;
		}

		if (objetivo.tieneEscudo()) {
			System.out.println("¡" + objetivo.getNombre() + " tenia escudo! El hechizo no surtió efecto.");
			objetivo.desactivarEscudo();
			return false;
		}

		System.out.println("" + this.getNombre() + " intenta lanzar " + this.hechizoActual.getNombre() + ".");
		if (!puedeLanzarHechizo(this)) {
			System.out
					.println("¡" + this.getNombre() + " no tiene energia suficiente! Debe descansar para recuperarla.");
			nivelDeEnergia = 100;

			return false;
		}
		return true;
	}

	private boolean puedeLanzarHechizo(Personaje personaje) {

		if (!ImplementacionProlog.getPrologCargado())
			ImplementacionProlog.cargarProlog();

		String consulta = "hechizo(" + hechizoActual.getNombre().toLowerCase().replace(" ", "") + ",_)";
		Query consultaHechizo = new Query(consulta);
		if (consultaHechizo.hasSolution()) {
			consulta = "energia_suficiente(" + hechizoActual.getNombre().toLowerCase().replace(" ", "") + ", "
					+ nivelDeEnergia + ", NivelHechizo)";
			Query consultaEnergia = new Query(consulta);
			if (consultaEnergia.hasSolution()) {
				Term nivelHechizoTerm = consultaEnergia.nextSolution().get("NivelHechizo");
				int nivelHechizo = Integer.parseInt(nivelHechizoTerm.toString());
				this.disminuirNivelDeEnergia(nivelHechizo);
				return true;
			}
		} else {
			throw new RuntimeException("No hay información sobre el hechizo.");
		}
		return false;
	}

	public void activarHabilidadEspecial() {
	}

	public boolean tieneHabilidadesEspeciales() {
		return false;
	}

	public void usarHabilidadEspecial() {
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
		this.escudo = true;
	}

	public void desactivarEscudo() {
		this.escudo = false;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nNivel de magia: " + nivelDeMagia + "\nPuntos de Vida: " + puntosDeVida
				+ "\nNivel de energia: " + nivelDeEnergia + "\nHechizos" + hechizos;
	}

}
