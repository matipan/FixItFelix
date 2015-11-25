package grafica.menu;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu extends JFrame{
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "MainMenu.png";
	private JButton instrucciones, play, highscores;
	private ImageIcon playBoton = new ImageIcon(imgPath + "Play.png");
	private ImageIcon highscoresBoton= new ImageIcon(imgPath + "HighScores.png");
	private ImageIcon instruccionesBoton= new ImageIcon(imgPath + "Instrucciones.png");
	
	public MainMenu(){
		/*Menu principal que seria lo primero que aparece al lanzar la aplicacion.
		 *Primero Agrego los botones al menu principal.
		 */
        File image = new File(backgroundImage);

		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 550));
		configurarBotones();

		/*
		 * Actualmente, el flow entre ventanas es el siguiente:
		 * 		- Apreto boton por ejemplo "Instrucciones"
		 * 		- Se desabilita la visibilidad de la pantalla actual
		 * 		- Se crea la nueva pantalla y habilita la visibilidad
		 * Hay que preguntar si hay una mejor manera de hacerlo, por ahi reemplazando contenidos?
		 */
		instrucciones.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				setVisible(false);
				Instrucciones inst = new Instrucciones();
			}
		});

		highscores.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				setVisible(false);
				TopScores tps = new TopScores();
			}
		});


		/*EL titulo de la Ventana. Creo que igual deberia tener "Fix It Felix".
		 *El tama�o de la ventana � Frame esta justo para la imagen de fondo.
		 */
		setTitle("MainMenu");
		setSize(919,720);
		setVisible(true);
	}
	
	private void configurarBotones(){
		instrucciones = new JButton();
		play = new JButton();
		highscores = new JButton();
		play.setIcon(playBoton);
		highscores.setIcon(highscoresBoton);
		instrucciones.setIcon(instruccionesBoton);
		highscores.setBorder(null);
		play.setBorder(null);
		instrucciones.setBorder(null);
		add(highscores, BorderLayout.EAST); add(play, BorderLayout.CENTER);
		add(instrucciones, BorderLayout.WEST);
	}
	
	public static void main (String[] args){
		MainMenu pruea = new MainMenu();
	}
	

}
