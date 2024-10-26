package com.edu.unlam.creacion;

import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.personajes.mortifagos.*;

public class PersonajeFactory {
	public static Mago crearMago() {	
		switch ((int) (Math.random() * 2)) {
		case 0:
			return new Profesor("Mago " + Mago.getContador(), 0, 0, null);
		case 1:
			return new Auror("Mago " + Mago.getContador(), 0, 0, null);
		case 2:
			return new Estudiante("Mago " + Mago.getContador(), 0, 0, null);
		default:
			return null;
		}
	}

	public static Mortifago crearMortifago() {
		switch ((int) (Math.random() * 1)) {
		case 0:
			return new Comandante("Mortifago " + Mortifago.getContador(), 0, 0, null);
		case 1:
			return new Seguidor("Mortifago " + Mortifago.getContador(), 0, 0, null);
		default:
			return null;
		}
	}
}
