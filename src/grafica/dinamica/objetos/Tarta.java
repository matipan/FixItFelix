package grafica.dinamica.objetos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import modelo.direcciones;
import grafica.dinamica.GGO;
import javax.imageio.ImageIO;

public class Tarta extends GGO {
  private String imgPath = "src/grafica/imagenes/pastel/";
	private BufferedImage tar1, tar2;
  // izq o der indican dirección de vuelo
  // AA: ala alta + AB: ala baja
  private Timer timer;

  public Tarta (double x, double y) {
    this.timer = new Timer(DELAY, this);
    this.timer.start();
    this.uploadImages();
    this.setX(x);
    this.setY(y);
  }

  private void uploadImages () {
    try {
      if (tar1 == null) {
          tar1 = ImageIO.read(new File(imgPath + "slice12_12.png"));
      }
      if (tar1 == null) {
        tar2 = ImageIO.read(new File(imgPath + "slice13_13.png"));
      }
    } catch (IOException e) {
      System.out.println("Internal Error:" + e.getMessage());
    }
  }
}