package com.edu.unlam.tests;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.edu.unlam.hechizos.*;
import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.personajes.mortifagos.*;

class BatallaTests {

	//pruebas de personaje
	@Test
	void testReducirNivelDeVida() {
		List<Hechizo> hechizos = new LinkedList<Hechizo>();
		//hechizos.add(new Bombarda());
		//hechizos.add(new Expeliarmus());
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Bombarda());
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		
		//Juan.getPuntosDeVida();
		
		Fran.lanzarHechizo(Juan);
		assertEquals(50, Juan.getPuntosDeVida());
	}

	@Test
	void testEfectosArmar() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Bombarda());
		Fran.desarmar();
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		Fran.lanzarHechizo(Juan);
		assertEquals(true, Fran.estaArmado());
	
	}
	
	@Test
	void testEfectosAturdir() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Bombarda());
		Fran.aturdir();
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		Fran.lanzarHechizo(Juan);
		assertEquals(false, Fran.estaAturdido());
	
	}
	
	@Test
	void testEfectosEscudo() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Bombarda());
		
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		Juan.activarEscudo();
		
		Fran.lanzarHechizo(Juan);
		
		assertEquals(false, Juan.tieneEscudo());
	
	}
	
	/////////////////////////////pruebas de hechizos/////////////////////////////
	@Test
	void testHechizoAvadaKedavra() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new AvadaKedavra());
		
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		
		
		Fran.lanzarHechizo(Juan);
		
		assertEquals(0, Juan.getPuntosDeVida());//CERO
	
	}
	
	@Test
	void testHechizoBombarda() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Bombarda());
		
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		
		
		Fran.lanzarHechizo(Juan);
		
		assertEquals(50, Juan.getPuntosDeVida());//CERO
	
	}
	
	@Test
	void testHechizoConfringo() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Confringo());
		
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		
		
		Fran.lanzarHechizo(Juan);
		
		assertEquals(1, Juan.getPuntosDeVida());//CERO
	
	}
	
	@Test
	void testHechizoCrucio() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Crucio());
		
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		
		
		Fran.lanzarHechizo(Juan);
		
		assertEquals(50, Juan.getPuntosDeVida());//CERO
	
	}
	
	@Test
	void testHechizoDesmaius() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Desmaius());
		
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		
		Fran.lanzarHechizo(Juan);
		
		assertEquals(true, Juan.estaAturdido());//CERO
	
	}
	
	@Test
	void testHechizoExpeliarmus() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Expelliarmus());
		
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		
		Fran.lanzarHechizo(Juan);
		
		assertEquals(false, Juan.estaArmado());//CERO
	
	}
	
	@Test
	void testHechizoProtego() {
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 100, null);
		Fran.setHechizoActual(new Protego());
		
		Comandante Juan = new Comandante("Juan Luis", 100, 100, null);
		
		Fran.lanzarHechizo(Juan);
		
		assertEquals(true, Juan.tieneEscudo());//CERO
	
	}
	/////////////////////////////////////////////////////////////////////////////
	
	//pruebas de Batallon
	/*@Test
	void testBatallonMap() {
		Batallon b = new Batallon();
		
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 1000, null);
		Fran.setHechizoActual(new AvadaKedavra());
		Profesor Lila = new Profesor("Lila Gomez", 100, 1000, null);
		Lila.setHechizoActual(new Expeliarmus());
		Auror juan = new Auror("Juan Gomez", 100, 1000, null);
		Lila.setHechizoActual(new Expeliarmus());
		juan.setHechizoActual(new AvadaKedavra());
		
		b.agregarPersonaje(juan);
		b.agregarPersonaje(Lila);
		b.agregarPersonaje(Fran);
		System.out.println("////////////////");
		b.mostrarHechizosLanzados();
		
		assertEquals(false, Juan.tieneEscudo());
	
	}*/
	
}
