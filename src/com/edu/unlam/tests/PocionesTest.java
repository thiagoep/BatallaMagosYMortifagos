package com.edu.unlam.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.edu.unlam.hechizos.AtaqueBasico;
import com.edu.unlam.hechizos.Hechizo;
import com.edu.unlam.personajes.Personaje;
import com.edu.unlam.personajes.magos.Estudiante;
import com.edu.unlam.pociones.*;

public class PocionesTest {
	private Personaje objetivo;
	private List<Hechizo> hechizos;

	@Before
	public void setUp() {
		hechizos = new ArrayList<>();
		hechizos.add(new AtaqueBasico());
		objetivo = new Estudiante("Hermione", 80, 100, hechizos);
	}

	@Test
	public void testEsenciaDeMurtlap() {
		Pocion pocion = new EsenciaDeMurtlap();
		objetivo.disminuirPuntosDeVida(80);
		pocion.usar(objetivo);
		assertEquals(100, objetivo.getPuntosDeVida()); // Debería curar toda la vida
	}

	@Test
	public void testAmortentia() {
		Pocion pocion = new Amortentia();
		pocion.usar(objetivo);
		assertTrue(objetivo.tieneEscudo()); // Debería tener escudo
	}

	@Test
	public void testFelixFelicis() {
		Pocion pocion = new FelixFelicis();
		objetivo.disminuirNivelDeEnergia(90);
		pocion.usar(objetivo);
		assertEquals(100, objetivo.getNivelDeEnergia()); // Debería recargar su energia
	}
}
