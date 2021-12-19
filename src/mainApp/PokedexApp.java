package mainApp;

import java.util.ArrayList;
import java.util.List;

import models.Pokemon;
import models.User;
import views.LoginView;

public class PokedexApp {

	private static List<Pokemon> pokemons = new ArrayList<>();
	private static List<User> usersList = new ArrayList<>();
	public static User user;
	
	public static void main(String[] args) {
		new LoginView();
		usersList.add(new User("test", "test"));
		addPokemons();
	}
	
	// Métodos
	private static void addPokemons() {
		pokemons.add(new Pokemon(1, "Bulbasur", "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.", "", null, null, 0, 0))
	}
	
	
	// Getters y Setters
	
	public static List<Pokemon> getPokemons() {
		return pokemons;
	}

	public static List<User> getUsersList() {
		return usersList;
	}

	
}
