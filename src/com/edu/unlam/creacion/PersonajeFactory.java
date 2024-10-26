package com.edu.unlam.creacion;

import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.personajes.mortifagos.*;

public class PersonajeFactory {
	public static Mago crearMago() {
		switch ((int) (Math.random() * 2)) {
			case 0:
			return new Profesor("Mago " + Mago.getContador(), 80 + (int) (Math.random() * 20), 60 + (int) (Math.random() * 20), null);
			case 1:
			return new Auror("Mago " + Mago.getContador(), 70 + (int) (Math.random() * 30), 80 + (int) (Math.random() * 20), null);
			case 2:
			return new Estudiante("Mago " + Mago.getContador(), 40 + (int) (Math.random() * 30), 70 + (int) (Math.random() * 10), null);
			default:
			return null;
		}
	}

	public static Mortifago crearMortifago() {
			switch ((int) (Math.random() * 1)) {
			case 0:
			return new Comandante("Mortifago " + Mortifago.getContador(), 85 + (int) (Math.random() * 15), 80 + (int) (Math.random() * 20), null);
			case 1:
			return new Seguidor("Mortifago " + Mortifago.getContador(), 60 + (int) (Math.random() * 20), 60 + (int) (Math.random() * 20), null);
			default:
			return null;
		}
	}
}
