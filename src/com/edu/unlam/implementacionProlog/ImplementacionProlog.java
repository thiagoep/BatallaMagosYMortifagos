package com.edu.unlam.implementacionProlog;

import org.jpl7.Query;

public class ImplementacionProlog {

	private static boolean prologCargado = false;

	public static void cargarProlog() {
		if (!prologCargado) { // Verifica si Prolog ya ha sido cargado
			String consultaCarga = "consult('consultas.pl')";
			Query qCarga = new Query(consultaCarga);
			prologCargado = qCarga.hasSolution(); // Solo carga una vez

			if (!prologCargado) {
				throw new RuntimeException("Error: No se pudo cargar el archivo Prolog correctamente.");
			}
		}
	}

	public static boolean getPrologCargado() {
		return prologCargado;
	}

}
