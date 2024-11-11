package com.edu.unlam.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.edu.unlam.hechizos.*;
import com.edu.unlam.personajes.Personaje;
import com.edu.unlam.personajes.magos.*;

import static org.junit.Assert.*;

public class HechizoTest {
	private Personaje objetivo;
	private List<Hechizo> hechizos;

	@Before
	public void setUp() {
		hechizos = new ArrayList<>();
		hechizos.add(new AtaqueBasico());
		objetivo = new Estudiante("Hermione", 80, 100, hechizos);
	}

	@Test
	public void testAtaqueBasico() {
		Hechizo hechizo = new AtaqueBasico();
		hechizo.ejecutar(objetivo);
		assertEquals(90, objetivo.getPuntosDeVida()); // Debería restar 10 puntos de vida
	}

	@Test
	public void testExpelliarmus() {
		Hechizo hechizo = new Expelliarmus();
		hechizo.ejecutar(objetivo);
		assertFalse(objetivo.estaArmado()); // Debería estar desarmado
	}

	@Test
	public void testGlaciusMaxima() {
		Hechizo hechizo = new GlaciusMaxima();
		hechizo.ejecutar(objetivo);
		assertTrue(objetivo.estaAturdido()); // Debería estar aturdido
		assertEquals(80, objetivo.getPuntosDeVida()); // Debería restar 20 puntos de vida
	}

	@Test
	public void testIncendio() {
		Hechizo hechizo = new Incendio();
		hechizo.ejecutar(objetivo);
		assertEquals(50, objetivo.getPuntosDeVida()); // Debería restar 50 puntos de vida
	}

	@Test
	public void testPetrificus() {
		Hechizo hechizo = new Petrificus();
		hechizo.ejecutar(objetivo);
		assertTrue(objetivo.estaAturdido()); // Debería estar aturdido
	}

	@Test
	public void testProtego() {
		Hechizo hechizo = new Protego();
		hechizo.ejecutar(objetivo);
		assertTrue(objetivo.tieneEscudo()); // Debería tener escudo
	}

	@Test
	public void testReverse() {
		Hechizo hechizo = new Reverse();
		objetivo.disminuirPuntosDeVida(50);
		hechizo.ejecutar(objetivo);
		assertEquals(100, objetivo.getPuntosDeVida()); // Debería curar todos los puntos de vida
	}

	@Test
	public void testVitalisRevoco() {
		Hechizo hechizo = new VitalisRevoco();
		objetivo.disminuirPuntosDeVida(50);
		hechizo.ejecutar(objetivo);
		assertEquals(80, objetivo.getPuntosDeVida()); // Debería curar 30 puntos de vida
	}

	@Test
	public void testBombarda() {
		Hechizo hechizo = new Bombarda();
		hechizo.ejecutar(objetivo);
		assertEquals(50, objetivo.getPuntosDeVida()); // Debería restar 50 puntos de vida
	}

	@Test
	public void testAvadaKedavra() {
		Hechizo hechizo = new AvadaKedavra();
		hechizo.ejecutar(objetivo);
		assertEquals(0, objetivo.getPuntosDeVida()); // Debería restar todos los puntos de vida
	}

	@Test
	public void testConfringo() {
		Hechizo hechizo = new Confringo();
		hechizo.ejecutar(objetivo);
		assertEquals(1, objetivo.getPuntosDeVida()); // Debería dejar a 1 punto de vida
		hechizo.ejecutar(objetivo);
		assertEquals(0, objetivo.getPuntosDeVida()); // Debería restar todos los puntos de vida
	}

	@Test
	public void testDesmaius() {
		Hechizo hechizo = new Desmaius();
		hechizo.ejecutar(objetivo);
		assertTrue(objetivo.estaAturdido()); // Debería estar aturdido
	}

	@Test
	public void testCrucio() {
		Hechizo hechizo = new Crucio();
		hechizo.ejecutar(objetivo);
		assertEquals(49, objetivo.getPuntosDeVida()); // Debería restar la mitad de los puntos de vida mas 1
	}

	@Test
	public void testFulminisLacertae() {
		Hechizo hechizo = new FulminisLacertae();
		hechizo.ejecutar(objetivo);
		assertEquals(40, objetivo.getPuntosDeVida()); // Debería restar 60 puntos de vida
	}
}
