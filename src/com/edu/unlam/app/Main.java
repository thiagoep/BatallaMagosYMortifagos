package com.edu.unlam.app;

public class Main {
	public static void main(String[] args) {
		try {
			Batalla.simularBatalla(1, 1);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No has seguido las reglas, se ha terminado el juego.");
			System.exit(1);
		}
	}
}
