package views;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mainApp.PokedexApp;
import models.Pokemon;
import utils.AppUtils;
import utils.ImageUtils;
import utils.RoundedJPanel;

public class PokedexView {

	private JFrame frame;
	
	private Pokemon pokemon;

	/**
	 * Inicia la vista Pokedex
	 */
	public PokedexView() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Muestra el contenido de la vista
	 */
	private void initialize() {
		pokemon = PokedexApp.getPokemons().get(0);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(AppUtils.BACKGROUND_COLOR);
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel topPanel = new RoundedJPanel(40, 40);
		topPanel.setBounds(0, -22, 484, 298);
		topPanel.setForeground(new Color(0, 0, 0, 0));
		topPanel.setBackground(new Color(201, 177, 0));
		topPanel.setOpaque(false);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JButton returnButton = new JButton("");
		returnButton.setIcon(new ImageIcon(PokedexView.class.getResource("/assets/img/return.png")));
		returnButton.setEnabled(false);
		returnButton.setBounds(10, 39, 32, 28);
		topPanel.add(returnButton);
		
		JLabel returnTextLabel = new JLabel("Pokedex");
		returnTextLabel.setForeground(Color.WHITE);
		returnTextLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 18));
		returnTextLabel.setBounds(69, 33, 115, 34);
		topPanel.add(returnTextLabel);
		
		JLabel pokemonNameLabel = new JLabel(pokemon.getName());
		pokemonNameLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 24));
		pokemonNameLabel.setForeground(Color.WHITE);
		pokemonNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pokemonNameLabel.setBounds(10, 300, 464, 39);
		frame.getContentPane().add(pokemonNameLabel);
		
		// Caja superior redondeada
		JPanel panel = new RoundedJPanel(20, 20);
		panel.setBounds(171, 350, 154, 26);
		panel.setForeground(new Color(0, 0, 0, 0));
		panel.setBackground(new Color(219, 192, 0));
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
		
		// Imagen del pokemon
		JLabel pokemonImage = new JLabel("");
		pokemonImage.setHorizontalAlignment(SwingConstants.CENTER);
		pokemonImage.setBounds(79, 78, 316, 190);
		
		try {
			URL url = new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/" + ImageUtils.getPokemonById(pokemon.getId()));
			pokemonImage.setIcon(new ImageIcon(ImageIO.read(url)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		topPanel.add(pokemonImage);
	}
}
