package com.edu.unlam.app;

import java.util.*;
import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.hechizos.*;

public class Batalla {
	public static void main(String[] args) {
		List<Hechizo> hechizos = new LinkedList<Hechizo>();
		hechizos.add(new AvadaKedavra());
		hechizos.add(new Expeliarmus());
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 1000, hechizos);
		Estudiante Harry = new Estudiante("Harry Potter", 100, 1000, hechizos);
		Fran.setHechizoActual(new AvadaKedavra());
		Fran.lanzarHechizo(Harry);
		
	}
}
