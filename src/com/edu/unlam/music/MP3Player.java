package com.edu.unlam.music;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MP3Player {

	public static void play(String filePath) {
		try (FileInputStream fis = new FileInputStream(filePath)) {
			Player player = new Player(fis);
			player.play();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado: " + e.getMessage());
		} catch (JavaLayerException e) {
			System.out.println("Error al reproducir MP3: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
