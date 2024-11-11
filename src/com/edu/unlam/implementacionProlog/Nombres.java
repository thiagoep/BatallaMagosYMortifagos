package com.edu.unlam.implementacionProlog;

import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

public class Nombres {

	private static ArrayList<String> estudiante = new ArrayList<String>(20);
	private static ArrayList<String> profesor = new ArrayList<String>(11);
	private static ArrayList<String> auror = new ArrayList<String>(6);
	private static ArrayList<String> comandante = new ArrayList<String>(7);
	private static ArrayList<String> seguidor = new ArrayList<String>(12);
	private static Set<String> nombresAleatorios = new HashSet<>();
	private static boolean carga = false;

	private static void cargaDeNombres() {
		String archivoProlog = "nombres.pl";
		Query cargarArchivo = new Query("consult", new Term[] { new Atom(archivoProlog) });

		if (!cargarArchivo.hasSolution()) {
			throw new RuntimeException("Error: No se pudo cargar el archivo Prolog correctamente.");
		}

		String consulta = "mortifago(Nombre, comandante)";
		Query q = new Query(consulta);

		while (q.hasMoreSolutions()) {
			Map<String, Term> solucion = q.nextSolution();
			String nombre = solucion.get("Nombre").toString();
			nombre = nombre.replace("'", "");
			comandante.add(nombre);
		}

		consulta = "mortifago(Nombre, seguidor)";
		q = new Query(consulta);

		while (q.hasMoreSolutions()) {
			Map<String, Term> solucion = q.nextSolution();
			String nombre = solucion.get("Nombre").toString();
			nombre = nombre.replace("'", "");
			seguidor.add(nombre);
		}

		consulta = "mago(Nombre, auror)";
		q = new Query(consulta);

		while (q.hasMoreSolutions()) {
			Map<String, Term> solucion = q.nextSolution();
			String nombre = solucion.get("Nombre").toString();
			nombre = nombre.replace("'", "");
			auror.add(nombre);
		}

		consulta = "mago(Nombre, profesor)";
		q = new Query(consulta);

		while (q.hasMoreSolutions()) {
			Map<String, Term> solucion = q.nextSolution();
			String nombre = solucion.get("Nombre").toString();
			nombre = nombre.replace("'", "");
			profesor.add(nombre);
		}

		consulta = "mago(Nombre, estudiante)";
		q = new Query(consulta);

		while (q.hasMoreSolutions()) {
			Map<String, Term> solucion = q.nextSolution();
			String nombre = solucion.get("Nombre").toString();
			nombre = nombre.replace("'", "");
			estudiante.add(nombre);
		}

		q.close();
		carga = true;

		Collections.shuffle(estudiante);
		Collections.shuffle(profesor);
		Collections.shuffle(auror);
		Collections.shuffle(comandante);
		Collections.shuffle(seguidor);

	}

	private static String nombreAleatorio() {
		int maxIntentos = 1000;
		int intentos = 0;
		Random rand = new Random();

		String archivoProlog = "nombres.pl";
		Query cargarArchivo = new Query("consult", new Term[] { new Atom(archivoProlog) });
		cargarArchivo.hasSolution();

		while (intentos < maxIntentos) {

			Query consultaAleatoria;

			if (rand.nextBoolean()) {
				consultaAleatoria = new Query("nombre_personaje_femenino(Nombre)");
			} else {
				consultaAleatoria = new Query("nombre_personaje_masculino(Nombre)");
			}

			if (consultaAleatoria.hasMoreSolutions()) {
				Map<String, Term> solucion = consultaAleatoria.nextSolution();
				String nombre = solucion.get("Nombre").toString();
				if (nombresAleatorios.add(nombre)) {
					consultaAleatoria.close();
					return nombre;
				}
			}
			consultaAleatoria.close();
			intentos++;
		}

		return "No hay nombres disponibles";
	}

	public static String nombreProfesor() {
		if (!carga)
			cargaDeNombres();

		try {
			return profesor.removeFirst();
		} catch (NoSuchElementException e) {
			return nombreAleatorio();
		}
	}

	public static String nombreAuror() {
		if (!carga)
			cargaDeNombres();

		try {
			return auror.removeFirst();
		} catch (NoSuchElementException e) {
			return nombreAleatorio();
		}
	}

	public static String nombreEstudiante() {
		if (!carga)
			cargaDeNombres();

		try {
			return estudiante.removeFirst();
		} catch (NoSuchElementException e) {
			return nombreAleatorio();
		}
	}

	public static String nombreSeguidor() {
		if (!carga)
			cargaDeNombres();

		try {
			return seguidor.removeFirst();
		} catch (NoSuchElementException e) {
			return nombreAleatorio();
		}
	}

	public static String nombreComandante() {
		if (!carga)
			cargaDeNombres();

		try {
			return comandante.removeFirst();
		} catch (NoSuchElementException e) {
			return nombreAleatorio();
		}
	}

}
