package com.edu.unlam.creacion;

import java.util.ArrayList;
import java.util.List;

import com.edu.unlam.hechizos.*;
import com.edu.unlam.implementacionProlog.Nombres;
import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.personajes.mortifagos.*;

public class PersonajeFactory {

	private static int nivelDeMagia;

	private static List<Hechizo> hechizos = new ArrayList<Hechizo>();

	public static Mago crearMago() {
		switch ((int) (Math.random() * 3)) {
		case 0:
			nivelDeMagia = 70 + (int) (Math.random() * 30);
			hechizos = HechizoFactory.crearHechizoMago(nivelDeMagia);
			return new Profesor(Nombres.nombreProfesor(), nivelDeMagia, 60 + (int) (Math.random() * 20), hechizos);
		case 1:
			nivelDeMagia = 80 + (int) (Math.random() * 20);
			hechizos = HechizoFactory.crearHechizoMago(nivelDeMagia);
			return new Auror(Nombres.nombreAuror(), nivelDeMagia, 80 + (int) (Math.random() * 20), hechizos);
		default:
			nivelDeMagia = 40 + (int) (Math.random() * 30);
			hechizos = HechizoFactory.crearHechizoMago(nivelDeMagia);
			return new Estudiante(Nombres.nombreEstudiante(), nivelDeMagia, 70 + (int) (Math.random() * 10), hechizos);
		}
	}

	public static Mortifago crearMortifago() {

		switch ((int) (Math.random() * 2)) {
		case 0:
			nivelDeMagia = 85 + (int) (Math.random() * 15);
			hechizos = HechizoFactory.crearHechizoMortifago(nivelDeMagia);
			return new Comandante(Nombres.nombreComandante(), nivelDeMagia, 80 + (int) (Math.random() * 20), hechizos);
		default:
			nivelDeMagia = 60 + (int) (Math.random() * 20);
			hechizos = HechizoFactory.crearHechizoMortifago(nivelDeMagia);
			return new Seguidor(Nombres.nombreSeguidor(), nivelDeMagia, 60 + (int) (Math.random() * 20), hechizos);
		}
	}

}