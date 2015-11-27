package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import modelo.direcciones.Direccion;
import modelo.main.Main;
import view.Grafica;

public class Controlador {
	private Grafica view;
	private Main model;
	
	public Controlador(){}
	
	public Controlador(Grafica view, Main model){
		this.view=view;
		this.model=model;
	}
	/*Creo que de esta forma se deberia manejar con el Controlador. Cualquier cosa si ven
	 * que se puede cambiar lo que sea para hacerlo mejor, mporque no se si les va a parecer 
	 * un lio de clases, pero bueno jaj. Lo que va a relacionar el modelo con la grafica
	 * va a ser el Boton Play, que ahi cree la clase, pero no mas que eso por cuestiones
	 * que se puede relacionar de muchas formas y no se como empezar.
	 */
	public static void main (String[] args){
		Controlador Ctrl = new Controlador();
		Ctrl.model = new Main(false, 1);
		Ctrl.view = new Grafica();
	}
	
	class moverListener implements KeyListener {
		
		public void keyPressed (KeyEvent e){
			int movek = e.getKeyCode();
			//Point P = Posicion de Imagen de Felix a usar creo
			if (movek == 38){		//Arriba
				model.getDvp().getFelix().mover(Direccion.ARRIBA);
				//P.setLocation(new Point((int) p.getX()),new Point((int) p.getY()+10);
			}
			if (movek == 40){		//Abajo
					model.getDvp().getFelix().mover(Direccion.ABAJO);
					//P.setLocation(new Point((int) p.getX()),new Point((int) p.getY()-10);
			}
			
		}
	}
	class playListener implements MouseListener {
		int p = view
	}
}
