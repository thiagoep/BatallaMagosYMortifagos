package com.edu.unlam.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.edu.unlam.hechizos.*;
import com.edu.unlam.personajes.Personaje;
import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.personajes.mortifagos.*;

import static org.junit.Assert.*;

public class PersonajeTest {
	private Personaje personaje;
	private List<Hechizo> hechizos;
	private Personaje enemigo;
	private List<Hechizo> hechizosEnemigo;

	@Before
	public void setUp() {
		hechizos = new ArrayList<>();
		hechizos.add(new AtaqueBasico());
		hechizos.add(new Protego());

		hechizosEnemigo = new ArrayList<>();
		hechizosEnemigo.add(new AtaqueBasico());
		hechizosEnemigo.add(new Crucio());

		personaje = new Estudiante("Hermione", 80, 100, hechizos);
		enemigo = new Seguidor("Draco Malfoy", 90, 80, hechizosEnemigo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNombreNulo() {
		new Estudiante(null, 10, 100, hechizos);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNivelDeMagiaNegativo() {
		new Estudiante("Harry Potter", -1, 100, hechizos);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorPuntosDeVidaCero() {
		new Estudiante("Harry", 10, 0, hechizos);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorPuntosDeVidaNegativos() {
		new Estudiante("Harry", 10, -1, hechizos);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorHechizosNulos() {
		new Estudiante("Harry", 10, 100, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorHechizosVacia() {
		new Estudiante("Harry", 10, 100, new ArrayList<>());
	}

	@Test
	public void testDisminuirPuntosDeVida() {
		personaje.disminuirPuntosDeVida(20);
		assertEquals(80, personaje.getPuntosDeVida());
	}

	@Test(expected = RuntimeException.class)
	public void testDisminuirPuntosDeVidaNegativos() {
		personaje.disminuirPuntosDeVida(-10);
	}

	@Test
	public void testAumentarPuntosDeVida() {
		personaje.disminuirPuntosDeVida(50);
		personaje.aumentarPuntosDeVida(30);
		assertEquals(80, personaje.getPuntosDeVida());
	}

	@Test
	public void testAumentarPuntosDeVidaExcedeMaximo() {
		personaje.aumentarPuntosDeVida(50);
		assertEquals(personaje.getVidaMaxima(), personaje.getPuntosDeVida());
	}

	@Test
	public void testDisminuirNivelDeEnergia() {
		personaje.disminuirNivelDeEnergia(20);
		assertEquals(80, personaje.getNivelDeEnergia());
	}

	@Test(expected = RuntimeException.class)
	public void testDisminuirNivelDeEnergiaNegativa() {
		personaje.disminuirNivelDeEnergia(-5);
	}

	@Test
	public void testRecuperarEnergia() {
		personaje.disminuirNivelDeEnergia(50);
		personaje.recuperarEnergia();
		assertEquals(100, personaje.getNivelDeEnergia());
	}

	@Test
	public void testGetHechizoAleatorio() {
		Hechizo hechizo = personaje.getHechizoAleatorio();
		assertNotNull(hechizo);
		assertTrue(hechizos.contains(hechizo));
	}

	@Test
	public void testLanzarHechizoNormal() {
		personaje.setHechizoActual(hechizos.getFirst());
		assertTrue(personaje.lanzarHechizo(enemigo));
		assertEquals(70, enemigo.getPuntosDeVida());
	}

	@Test
	public void testLanzarHechizoAturdido() {
		personaje.aturdir();
		assertFalse(personaje.lanzarHechizo(enemigo));
		assertFalse(personaje.estaAturdido()); // Verifica que el personaje se despierte
	}

	@Test
	public void testLanzarHechizoSinVarita() {
		personaje.desarmar();
		assertFalse(personaje.lanzarHechizo(enemigo));
		assertTrue(personaje.estaArmado()); // Verifica que el personaje se arme
	}

	@Test
	public void testLanzarHechizoConEscudo() {
		enemigo.activarEscudo();
		assertFalse(personaje.lanzarHechizo(enemigo));
		assertFalse(enemigo.tieneEscudo()); // Verifica que el escudo se desactive
	}

	@Test
	public void testLanzarHechizoSinEnergia() {
		personaje.setHechizoActual(hechizos.getFirst());
		personaje.disminuirNivelDeEnergia(96);
		assertFalse(personaje.lanzarHechizo(enemigo));
		assertEquals(100, personaje.getNivelDeEnergia()); // Verifica que se recargue la energia
	}

	@Test
	public void testLanzarHechizoHaciaSiMismo() {
		personaje.setHechizoActual(hechizos.getLast());
		assertTrue(personaje.lanzarHechizo(enemigo));
		assertTrue(personaje.tieneEscudo()); // Verifica que se active el escudo }
	}

	@Test
	public void testActivarMarcaTenebrosa() {
		enemigo.activarHabilidadEspecial();
		assertTrue(enemigo.tieneHabilidadesEspeciales());
	}

	@Test
	public void testUsarMarcaTenebrosa() {
		enemigo.activarHabilidadEspecial();
		enemigo.usarHabilidadEspecial();
		assertFalse(enemigo.tieneHabilidadesEspeciales());
		assertEquals(100, enemigo.getNivelDeEnergia());
		assertEquals("Avada Kedavra", enemigo.getHechizoActual().getNombre());
	}

	@Test
	public void testCrearPocion() {
		personaje.activarHabilidadEspecial();
		assertTrue(personaje.tieneHabilidadesEspeciales());
	}

	@Test
	public void testUsarPocion() {
		int cont = 0;
		personaje.activarHabilidadEspecial();
		while (personaje.tieneHabilidadesEspeciales() && cont < 3) {
			personaje.usarHabilidadEspecial();
			cont++;
		}
		assertFalse(personaje.tieneHabilidadesEspeciales());
	}
}
