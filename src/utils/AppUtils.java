package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import mainApp.PokedexApp;

public class AppUtils {

	public static final Color BACKGROUND_COLOR = new Color(39, 45, 54);
	public static final Color TEXT_COLOR = Color.WHITE;
	public static final Color ERROR_COLOR = Color.RED;
	
	public static Font getPokemonFont() {
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, PokedexApp.class.getResourceAsStream("/assets/fonts/Pokemon Solid.ttf"));
			return font;
		} catch (IOException | FontFormatException e) {
			// ignore
			e.printStackTrace();
			return new Font("Rubik", Font.BOLD, 22);
		}
	}
}
