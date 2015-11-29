package grafica.niceland;

import java.awt.image.BufferedImage;

public class VentanaView {
	private BufferedImage imagenActual;
	private int offsetX, offsetY;

	public VentanaView(BufferedImage imagenActual, int offsetX, int offsetY){
		this.imagenActual = imagenActual;
		this.offsetX = offsetX;
		this.offsetY= offsetY;
	}

	public VentanaView(){}

	public BufferedImage getImagenActual(){
		return this.imagenActual;
	}

	public int getOffsetX(){
		return this.offsetX;
	}

	public int getOffsetY(){
		return this.offsetY;
	}

	public void setImagenActual(BufferedImage imagenActual) {
		this.imagenActual = imagenActual;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

}
