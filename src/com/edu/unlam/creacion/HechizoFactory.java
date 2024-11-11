package com.edu.unlam.creacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.edu.unlam.hechizos.*;

public class HechizoFactory {

	public static List<Hechizo> crearHechizoMago(int nivelDeMagia) {
		List<Hechizo> hechizos = new ArrayList<Hechizo>();

		hechizos.add(new Desmaius());
		hechizos.add(new Expelliarmus());
		hechizos.add(new Protego());

		if (nivelDeMagia > 60) {
			hechizos.add(new VitalisRevoco());
			hechizos.add(new Incendio());
			hechizos.add(new Petrificus());
		}

		if (nivelDeMagia > 80) {
			hechizos.add(new GlaciusMaxima());
			hechizos.add(new Bombarda());
			hechizos.add(new Reverse());
			hechizos.add(new FulminisLacertae());

		}

		Collections.shuffle(hechizos);

		return hechizos;
	}

	public static List<Hechizo> crearHechizoMortifago(int nivelDeMagia) {
		List<Hechizo> hechizos = new ArrayList<Hechizo>();

		hechizos.add(new AtaqueBasico());
		hechizos.add(new Desmaius());

		if (nivelDeMagia > 70) {
			hechizos.add(new Crucio());
		}

		if (nivelDeMagia > 90) {
			hechizos.add(new Confringo());
			hechizos.add(new FulminisLacertae());
		}

		Collections.shuffle(hechizos);

		return hechizos;
	}
}