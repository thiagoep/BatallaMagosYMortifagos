package com.edu.unlam.app;
import java.util.*;


import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;


import com.edu.unlam.personajes.magos.*;
import com.edu.unlam.hechizos.*;

public class Batalla {
	public static void main(String[] args) {
		
				
		List<Hechizo> hechizos = new LinkedList<Hechizo>();
		hechizos.add(new AvadaKedavra());
		hechizos.add(new Expelliarmus());
		Estudiante Fran = new Estudiante("Francisco Franco", 100, 1000, hechizos);
		Auror Harry = new Auror("Harry Potter", 100, 1000, hechizos);
		//Fran.setHechizoActual(new Protego());
		Fran.setHechizoActual(new Expelliarmus());
		//Fran.aturdir();
		if(!Fran.lanzarHechizo(Harry))
			System.out.println("NO HA SURTIDO EFECTO");
		/*
		
		 String filePath = "C:/Users/Abigail/Downloads/consultas.pl"; // Cambia a la ruta donde guardaste hechizos.pl
	        Query cargarArchivo = new Query("consult('" + filePath + "')");

	        // Verifica si el archivo se cargó correctamente
	        if (cargarArchivo.hasSolution()) {
	            System.out.println("Archivo Prolog cargado correctamente.");
	        } else {
	            System.out.println("No se pudo cargar el archivo Prolog.");
	            return;
	        }

	        // Consultar si el hecho "hechizo(expecto_patronum)" es verdadero
	        Query consultaHechizo = new Query("hechizo(expecto_patronum)");
	        System.out.println("¿El hechizo expecto_patronum existe?: " + consultaHechizo.hasSolution());

	        // Consultar si "energia_suficiente(harry_potter)" es verdadero
	        Query consultaEnergia = new Query("energia_suficiente(harry_potter)");
	        System.out.println("¿Harry Potter tiene energía suficiente?: " + consultaEnergia.hasSolution());

	        // Consultar si "varita_sauco_disponible" es verdadero
	        Query consultaVarita = new Query("varita_sauco_disponible");
	        System.out.println("¿La varita de sauco está disponible?: " + consultaVarita.hasSolution());
	    
	    
		 */
	    }
	
}