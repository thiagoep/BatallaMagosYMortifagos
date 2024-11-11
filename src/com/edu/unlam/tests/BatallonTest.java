package com.edu.unlam.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.edu.unlam.batallon.Batallon;
import com.edu.unlam.hechizos.*;
import com.edu.unlam.personajes.Personaje;
import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.personajes.mortifagos.*;

import static org.junit.Assert.*;

public class BatallonTest {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorBatallon_NombreNulo() {
		new Batallon(null);
	}

	@Test
	public void testTienePersonajesSaludables() {
		Batallon batallon = new Batallon("Batallon");
		assertFalse(batallon.tienePersonajesSaludables()); // Verifica si no hay personajes
	}

	@Test
	public void testAgregarPersonaje() {
		List<Hechizo> hechizos = new ArrayList<>();
		hechizos.add(new AtaqueBasico());
		Batallon batallon = new Batallon("Batallon");
		Personaje personaje = new Estudiante("Hermione", 80, 100, hechizos);

		batallon.agregarPersonaje(personaje);
		assertTrue(batallon.tienePersonajesSaludables()); // Verifica que haya personajes en el batallón
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAgregarPersonaje_Nulo() {
		Batallon batallon = new Batallon("Batallon");
		batallon.agregarPersonaje(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAgregarPersonaje_MortifagoEnBatallonMago() {
		List<Hechizo> hechizos = new ArrayList<>();
		hechizos.add(new AtaqueBasico());
		Batallon batallon = new Batallon("Batallon Mago");
		Personaje mago = new Estudiante("Hermione", 80, 100, hechizos);
		Personaje mortifago = new Seguidor("Draco", 90, 80, hechizos);

		batallon.agregarPersonaje(mago);
		batallon.agregarPersonaje(mortifago); // Debe lanzar una excepción
	}

	@Test
	public void testAtacarDerrotaPersonaje() {
		List<Hechizo> hechizosMago = new ArrayList<>();
		hechizosMago.add(new AtaqueBasico());

		List<Hechizo> hechizosMortifago = new ArrayList<>();
		hechizosMortifago.add(new AvadaKedavra());

		Batallon batallonMago = new Batallon("Batallon Mago");
		Batallon batallonMortifago = new Batallon("Batallon Mortifago");

		Personaje mago = new Estudiante("Hermione", 80, 100, hechizosMago);
		Personaje mortifago = new Seguidor("Draco", 90, 80, hechizosMortifago);

		batallonMago.agregarPersonaje(mago);
		batallonMortifago.agregarPersonaje(mortifago);

		batallonMortifago.atacar(batallonMago); // Realiza un ataque letal
		assertFalse(batallonMago.tienePersonajesSaludables()); // Verifica que el batallón enemigo haya sido afectado
	}

	@Test(expected = RuntimeException.class)
	public void testAtacarAlMismoBatallon() {
		List<Hechizo> hechizos = new ArrayList<>();
		hechizos.add(new AtaqueBasico());

		Batallon batallon = new Batallon("Batallon");

		Personaje mago = new Estudiante("Hermione", 80, 100, hechizos);
		batallon.agregarPersonaje(mago);

		batallon.atacar(batallon);
	}

	@Test
	public void testAtacarActivaHabilidadEspecial() {
		List<Hechizo> hechizos = new ArrayList<>();
		hechizos.add(new AtaqueBasico());

		Batallon batallonMago = new Batallon("Batallon Mago");
		Batallon batallonMortifago = new Batallon("Batallon Mortifago");

		Personaje mago = new Estudiante("Hermione", 80, 100, hechizos);
		Personaje mortifago = new Seguidor("Draco", 90, 80, hechizos);
		batallonMago.agregarPersonaje(mago);
		batallonMortifago.agregarPersonaje(mortifago);

		batallonMago.atacar(batallonMortifago);
		batallonMortifago.atacar(batallonMago);
		batallonMago.atacar(batallonMortifago);

		assertTrue(mortifago.tieneHabilidadesEspeciales()); // Verifica si el mortifago tiene la marca tenebrosa por
															// ganar la ronda
	}
}
