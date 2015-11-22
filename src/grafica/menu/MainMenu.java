package grafica.menu;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame{
	private String imgName = "MainMenu.png";
	private BufferedImage img;
	private Button instrucciones, play, highscores; 
	
	public MainMenu(){
		/*Menu principal que seria lo pripero que aparece al lanzar la aplicacion.
		 *Primero Agrego los botones al menu principal.
		 */
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));
		instrucciones = new Button("Instrucciones");
		play = new Button("Play");
		highscores = new Button("Highscores");
		add(highscores); add(play);
		add(instrucciones);
		/*Cargo la Imagen de esta forma. Se puede hacer desde entrada salida que
		 *creo que seria mucho mejor de esa forma, pero por ahora esto.
		 */
		URL imgURL = getClass().getClassLoader().getResource(imgName);
		if (imgURL == null)
			System.err.println("No se encuentra el archivo"+imgName);
		else {
			try{
				img= ImageIO.read(imgURL);
			}
			catch (IOException ex){
				ex.printStackTrace();
			}
		}
		/*EL titulo de la Ventana. Creo que igual deberia tener "Fix It Felix".
		 *El tama�o de la ventana � Frame esta justo para la imagen de fondo.
		 */
		setTitle("MainMenu");
		setSize(919,720);
		setVisible(true);
		dibujar();
	}
	
	public void dibujar (){
		Graphics gr = img.getGraphics();
		this.getGraphics().drawImage(img, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		dibujar();
	}
	public static void main (String[] args){
		MainMenu pruea = new MainMenu();
	}
	

}
