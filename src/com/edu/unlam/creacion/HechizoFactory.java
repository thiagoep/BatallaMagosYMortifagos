package com.edu.unlam.creacion;

import java.util.ArrayList;
import java.util.List;

import com.edu.unlam.hechizos.*;

public class HechizoFactory {
	
	public static List<Hechizo> crearHechizoMago(int nivelDeMagia) {
		List<Hechizo> hechizos = new ArrayList<Hechizo>();
		
		hechizos.add(new Desmaius());
		hechizos.add(new Expelliarmus());
		
		if(nivelDeMagia > 60) {
			hechizos.add(new Protego());
			hechizos.add(null);
		}
		
		if(nivelDeMagia > 80) {
			hechizos.add(new Bombarda());
			hechizos.add(null);
		}
		
		return hechizos;
	}
	
	public static List<Hechizo> crearHechizoMortifago(int nivelDeMagia) {
		List<Hechizo> hechizos = new ArrayList<Hechizo>();
		
		hechizos.add(null);
		hechizos.add(null);
		
		if(nivelDeMagia>60) {
			hechizos.add(null);
			hechizos.add(null);
		}
		
		if(nivelDeMagia>80) {
			hechizos.add(null);
			hechizos.add(null);
		}
		
		return hechizos;
	}
}