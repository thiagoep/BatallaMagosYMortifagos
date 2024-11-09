package com.edu.unlam.creacion;

import java.util.ArrayList;
import java.util.List;

import com.edu.unlam.hechizos.*;
import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.personajes.mortifagos.*;

public class PersonajeFactory {
	
	private static int nivelDeMagia;
	/*private String[] mortifagos = {
		    "Bellatrix Lestrange",
		    "Lucius Malfoy",
		    "Severus Snape",
		    "Fenrir Greyback",
		    "Barty Crouch Jr.",
		    "Alecto Carrow",
		    "Amycus Carrow",
		    "Antonin Dolohov",
		    "Regulus Black",
		    "Yaxley",
		    "Augustus Rookwood",
		    "Walden Macnair",
		    "Thorfinn Rowle",
		    "Crabbe Sr.",
		    "Goyle Sr.",
		    "Igor Karkaroff",
		    "Mulciber",
		    "Nott",
		    "Jugson",
		    "Travers"
		};
*/
	
	
	private static List<Hechizo> hechizos = new ArrayList<Hechizo>();
	
	public static Mago crearMago() {
		switch ((int) (Math.random() * 2)) {
		
			case 0:
				nivelDeMagia = 80 + (int) (Math.random() * 20);
				hechizos = HechizoFactory.crearHechizoMago(nivelDeMagia);
				return new Profesor("Mago " + Mago.getContador(), nivelDeMagia, 60 + (int) (Math.random() * 20), hechizos);
			
			case 1:
				nivelDeMagia = 70 + (int) (Math.random() * 30);
				hechizos = HechizoFactory.crearHechizoMago(nivelDeMagia);
				return new Auror("Mago " + Mago.getContador(), nivelDeMagia, 80 + (int) (Math.random() * 20), hechizos);
			case 2:
				nivelDeMagia = 40 + (int) (Math.random() * 30);
				hechizos = HechizoFactory.crearHechizoMago(nivelDeMagia);
				return new Estudiante("Mago " + Mago.getContador(), nivelDeMagia, 70 + (int) (Math.random() * 10), hechizos);
			default:
				return null;
		}
	}
	
	public static Mortifago crearMortifago() {
		switch ((int) (Math.random() * 1)) {
			case 0:
				nivelDeMagia = 85 + (int) (Math.random() * 15);
				hechizos = HechizoFactory.crearHechizoMortifago(nivelDeMagia);
				return new Comandante("Mortifago " + Mortifago.getContador(), nivelDeMagia, 80 + (int) (Math.random() * 20), hechizos);
			case 1:
				nivelDeMagia = 60 + (int) (Math.random() * 20);
				hechizos = HechizoFactory.crearHechizoMortifago(nivelDeMagia);
				return new Seguidor("Mortifago " + Mortifago.getContador(), nivelDeMagia, 60 + (int) (Math.random() * 20), hechizos);
			default:
				return null;
		}
	}

}